package com.myride.common.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@CreatedDate
	@Column(name = "CREATED_AT")
	@Temporal(value = TemporalType.DATE)
	private Long createdAt;
	@LastModifiedDate
	@Column(name = "LAST_MODIFFIED_BY")
	private Long lastModified;
	@CreatedBy
	@Column(name = "CREATED_BY")
	private String createdBy;
	@LastModifiedBy
	@Temporal(value = TemporalType.DATE)
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
}
