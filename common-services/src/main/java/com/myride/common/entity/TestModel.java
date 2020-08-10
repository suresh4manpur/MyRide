package com.myride.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Table(schema = "registration-db", name = "test_model")
@Data
public class TestModel {
	@Id
	private int id;
	private String comments;
}
