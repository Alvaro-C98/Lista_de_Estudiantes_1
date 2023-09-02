package com.mvc.student.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.student.models.Contacts;

@Repository
public interface ContactRepository extends CrudRepository<Contacts,Long>{
	
}
