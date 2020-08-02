package com.myride.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myride.registration.entity.TestModel;

public interface TestRepository extends JpaRepository<TestModel, Integer>{

}
