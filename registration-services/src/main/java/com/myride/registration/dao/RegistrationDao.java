package com.myride.registration.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myride.common.entity.CabDetailsEntity;
import com.myride.registration.model.CabDetails;

@Repository
public interface RegistrationDao extends JpaRepository<CabDetailsEntity, String> {

}
