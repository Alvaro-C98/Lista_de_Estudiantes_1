package com.mvc.student.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String address;
    
    @NotNull
    private String city;
    
    @NotNull
    private String state;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Students student;
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Contacts () {
    	
    }
    
    public Contacts(String address, String city, String state, Students student) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.student=student;
	}
    
	public String getAddress() {
		return address;
	}
    
	public void setAddress(String address) {
		this.address = address;
	}
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Students getStudent() {
		return student;
	}
	
	public void setStudent(Students student) {
		this.student = student;
	}
    
}
