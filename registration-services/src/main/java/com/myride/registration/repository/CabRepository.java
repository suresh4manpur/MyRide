package com.myride.registration.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myride.common.entity.Cab;


@Repository
public interface  CabRepository extends JpaRepository<Cab, String>{

}
