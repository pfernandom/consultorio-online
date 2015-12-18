package com.consultorio.webapp.rest.controller;


import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.consultorio.core.dataaccess.entity.Patient;
import com.consultorio.core.dataaccess.repo.PatientRepository;
import com.consultorio.webapp.rest.exception.PatientNotFoundException;

@RestController
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	PatientRepository patientRepo;

	@RequestMapping(value = "/patients", method = RequestMethod.GET, produces = "application/json")
	public List<Patient> getAllPatients() {
		Iterable<Patient> patients = patientRepo.findAll();
		if(patients!=null){
			return IteratorUtils.toList(patients.iterator()); 
		}
		else{
			throw new PatientNotFoundException();
		}
	}
	
	@RequestMapping(value = "/*", method = RequestMethod.GET/*, produces = "application/json"*/)
	public String getAll() {
		System.err.println("No");
		return "Nel";
	}


	//@RequestParam(value="name", defaultValue="World") String name
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
		ex.printStackTrace();
		return "Exception: "+ex.getMessage();

	}
}
