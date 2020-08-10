package com.myride.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String documentId;

	private String document_for;

	private int document_Type;

	@Column(name="entity_id")
	private String entityId;

	@Column(name="media_type")
	private int mediaType;

	private String path;

	public Document() {
	}

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocument_for() {
		return this.document_for;
	}

	public void setDocument_for(String document_for) {
		this.document_for = document_for;
	}

	public int getDocument_Type() {
		return this.document_Type;
	}

	public void setDocument_Type(int document_Type) {
		this.document_Type = document_Type;
	}

	public String getEntityId() {
		return this.entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public int getMediaType() {
		return this.mediaType;
	}

	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}