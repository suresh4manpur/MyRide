package com.myride.registration.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myride.common.entity.User;


@Repository
public interface  UserRepository extends JpaRepository<User, String>{

}
