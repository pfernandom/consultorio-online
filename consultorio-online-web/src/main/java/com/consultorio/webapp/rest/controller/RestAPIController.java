package com.consultorio.webapp.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.core.dataaccess.entity.Address;
import com.consultorio.core.dataaccess.entity.Disease;
import com.consultorio.core.dataaccess.entity.Gender;
import com.consultorio.core.dataaccess.entity.HeredoFamilyBackground;
import com.consultorio.core.dataaccess.entity.Patient;
import com.consultorio.core.services.PatientService;

@RestController
@RequestMapping("/api")
public class RestAPIController {
	@Autowired
	PatientService patientService;


	@RequestMapping(value = "/patient", method = RequestMethod.GET, produces = "application/json")
	public List<Patient> getAllPatients() {
		patientService.createPatient(getTestPatient());
		return patientService.getAllPatients();
	}
	
	@RequestMapping(value = "/patient", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void>createPatient(@RequestBody Patient patient) {
		
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
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
	
public Patient getTestPatient(){
		
		Address address = new Address();
		address.setStreet("4701 Staggerbrush Rd");
		address.setCity("Austin");
		address.setState("Texas");
		
		Disease disease = new Disease();
		disease.setCode("D123456789");
		disease.setName("Diabetes");
		disease.setType("DM1");
		
		Patient patient = new Patient();
		patient.setFirstName("Pedro"+System.currentTimeMillis());
		patient.setGender(Gender.MALE);
		patient.setAddress(address);
		
		
		HeredoFamilyBackground familyBackground = new HeredoFamilyBackground();
		familyBackground.addDisease(disease);
		
		patient.setHereditaryFamilyBackground(familyBackground);
		
		return patient;
	}
}
