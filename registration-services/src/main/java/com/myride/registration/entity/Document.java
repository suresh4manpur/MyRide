package com.myride.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.myride.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
public class Document extends BaseEntity {
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	@Id
	private String docId;
	@Column(name = "doc_type", nullable = false, updatable = false)
	private String docType;
	@Column(name = "media_type", nullable = false, updatable = false)
	private String mediaType;
	@Transient
	private byte[] data;
	@Column(name = "doc_path", nullable = false, updatable = true)
	private String path;
}
