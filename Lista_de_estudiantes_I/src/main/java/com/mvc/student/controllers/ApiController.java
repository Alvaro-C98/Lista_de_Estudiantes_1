package com.mvc.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.student.models.Contacts;
import com.mvc.student.models.Students;
import com.mvc.student.services.ApiService;

import jakarta.validation.Valid;

@Controller
public class ApiController{
	
    @Autowired
    private ApiService apiService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/students";
	}
    
    @GetMapping("/students")
    public String index(Model model) {
        List<Students> student = apiService.allStudents();
        model.addAttribute("student", student);
        return "index.jsp";
    }
	
	@GetMapping("/students/create")
	public String createStudent(@RequestParam(value="firstName",required=false) String name, 
			@RequestParam(value="lastName",required=false) String last,
			@RequestParam(value="age",required=false) Integer age, 
			RedirectAttributes error) {
		if(name==null || last==null || age==null || age<6) {
			error.addFlashAttribute("error","Error creating a student");
			return  "redirect:/";
		}
		Students student = new Students(name,last,age);
		apiService.createStudent(student);
		return "redirect:/";
	}
	
    @GetMapping("/students/new")
    public String student(@ModelAttribute("student") Students student) {
        return "newStudent.jsp";
    }
	
    @PostMapping("/students/new")
    public String createStudent(@Valid @ModelAttribute("student") Students student, BindingResult result) {
        if (result.hasErrors()) {
            return "newStudent.jsp";
        } else {
            apiService.createStudent(student);
            return "redirect:/";
        }
    }
    
	@GetMapping("/contacts/create")
	public String createContact(@RequestParam(value="student",required=false) Long id,
			@RequestParam(value="address",required=false) String address, 
			@RequestParam(value="city",required=false) String city,
			@RequestParam(value="state",required=false) String state, 
			RedirectAttributes error) {
		if(address==null || city==null || state==null || findId(id)==false) {
			error.addFlashAttribute("error","Error creating a student");
			return  "redirect:/";
		}
		Students student = apiService.findStudent(id);
		Contacts contact = new Contacts(address,city,state,student);
		apiService.createContcat(contact);
		return "redirect:/";
	}
	
    public boolean findId(Long id) {
    	Students student = apiService.findStudent(id);
    		if(student==null) {
        		return false;
        	}
        	return true;
    	
    }
    
    @GetMapping("/contact/new")
    public String contact(@ModelAttribute("contact") Contacts contact, Model model) {
    	List<Students> student = apiService.findIdNull();
    	model.addAttribute("student",student);
        return "newContact.jsp";
    }
    
    @PostMapping("/contact/new")
    public String createContact(@Valid @ModelAttribute("contact") Contacts contact, 
    		BindingResult result,
    		Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("student",apiService.findIdNull());
            return "newContact.jsp";
        } else {
            apiService.createContcat(contact);
            return "redirect:/";
        }
    }
	
}
