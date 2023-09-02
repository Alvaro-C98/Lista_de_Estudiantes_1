package com.mvc.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.student.models.Contacts;
import com.mvc.student.models.Students;
import com.mvc.student.repositories.ContactRepository;
import com.mvc.student.repositories.StudentRepository;

@Service
public class ApiService {
	@Autowired
	private StudentRepository stuRep;
	@Autowired
	private ContactRepository conRep;
	
	public List<Students> allStudents() {
		return stuRep.findAll();
	}
	
	public Students createStudent(Students s) {
		return stuRep.save(s);
	}
	
	public Students findStudent(Long id) {	
		Optional<Students> optionaltype = stuRep.findById(id);
	    if(optionaltype.isPresent()) {
	    	return optionaltype.get();
	    }else {
	        return null;
	    }
	 }
	
	public Contacts createContcat(Contacts c) {
		return conRep.save(c);
	}
	
	public List<Students> findIdNull() {
		return stuRep.findByContactIdIsNull();
	}
}
