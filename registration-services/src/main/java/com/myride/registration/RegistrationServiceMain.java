package com.myride.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.myride"})
public class RegistrationServiceMain 
{
    public static void main( String[] args )
    {
		SpringApplication.run(RegistrationServiceMain.class, args);

    }
}


