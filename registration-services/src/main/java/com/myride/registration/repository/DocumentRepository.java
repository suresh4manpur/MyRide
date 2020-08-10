package com.myride.registration.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myride.common.entity.Document;


@Repository
public interface  DocumentRepository extends JpaRepository<Document, String>{

}
