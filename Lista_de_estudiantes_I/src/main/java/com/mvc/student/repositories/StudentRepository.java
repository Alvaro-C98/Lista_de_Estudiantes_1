package com.mvc.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.student.models.Students;

@Repository
public interface StudentRepository extends CrudRepository<Students,Long>{
	List<Students> findAll();
	
	List<Students> findByContactIdIsNull();
}
