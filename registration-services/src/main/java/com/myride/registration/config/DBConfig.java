package com.myride.registration.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJpaRepositories(basePackages = { "com.myride.registration.repository" })
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = { "com.myride.registration.entity" })
@Slf4j
public class DBConfig {
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.hikari.connectionTimeout}")
	private String connectTimeOut;
	@Value("${spring.datasource.hikari.idleTimeout}")
	private String idleTimeOut;
	@Value("${spring.datasource.hikari.maxLifetime}")
	private String maxLifetime;
	@Value("${spring.datasource.hikari.maximumPoolSize}")
	private String maximumPoolSize;
	@Value("${spring.datasource.hikari.minimumIdle}")
	private String minimumIdle;
	@Value("${spring.datasource.hikari.poolName}")
	private String poolName;
	@Value("${spring.datasource.hikari.connectionTestQuery}")
	private String connectionTestQuery;
	@Value("${spring.datasource.hikari.autoCommit}")
	private boolean autoCommit;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;

	public HikariConfig hikariConfig() {
		HikariConfig config = new HikariConfig();

		config.setJdbcUrl(datasourceUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.setConnectionTimeout(Long.parseLong(connectTimeOut));
		config.setIdleTimeout(Long.parseLong(idleTimeOut));
		config.setMaxLifetime(Long.parseLong(maxLifetime));
		config.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
		config.setMinimumIdle(Integer.parseInt(minimumIdle));
		config.setPoolName(poolName);
		config.setConnectionTestQuery(connectionTestQuery);
		config.setAutoCommit(autoCommit);
		config.setDriverClassName(driverClass);

		return config;
	}

	@Bean
	@ConfigurationProperties("app.datasource")
	public HikariDataSource dataSource() {
		HikariConfig configProperties = hikariConfig();
		return new HikariDataSource(configProperties);
	}

	@PostConstruct
	public void postConstruct() {
		log.info("Database configuration loaded and db resources are initialized successfully!");
	}

}
