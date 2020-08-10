package com.myride.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="document_Id")
	private String documentId;

	@Column(name="document_for")
	private String documentFor;

	@Column(name="document_Type")
	private int documentType;

	@Column(name="entity_id")
	private String entityId;

	@Column(name="media_type")
	private int mediaType;
	
	@Column(name="path")
	private String path;


}