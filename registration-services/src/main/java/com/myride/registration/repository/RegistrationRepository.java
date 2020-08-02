package com.myride.registration.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myride.registration.entity.CabRegistration;

@Repository
public interface  RegistrationRepository extends JpaRepository<CabRegistration, String>{

}
