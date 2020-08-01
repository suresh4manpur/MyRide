package com.myride.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myride.registration.entity.TestModel;

public interface RegsitrationRepository extends JpaRepository<TestModel, Integer>{

}
