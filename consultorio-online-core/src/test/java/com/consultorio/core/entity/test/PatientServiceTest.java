package com.consultorio.core.entity.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.consultorio.core.dataaccess.entity.Address;
import com.consultorio.core.dataaccess.entity.Disease;
import com.consultorio.core.dataaccess.entity.Gender;
import com.consultorio.core.dataaccess.entity.HeredoFamilyBackground;
import com.consultorio.core.dataaccess.entity.Patient;
import com.consultorio.core.services.PatientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/app-main-context.xml")
@ActiveProfiles("application")
public class PatientServiceTest {
	//
	@Autowired
	PatientService partientService;
	
	
	
	@Before
	public void setUp() throws Exception {
		assertNotNull(partientService);
	}
	
	@After
	public void tearDown() throws Exception {
		//partientService.deleteAllPatients();
		
	}

	@Test
	public void createPatientTest() {
		Patient result = partientService.createPatient(getTestPatient());
		assertNotNull(result);
	}
	
	@Test
	public void getAllPatientsTest() {
		Patient result = partientService.createPatient(getTestPatient());
		assertNotNull(result);
		List<Patient> patients = partientService.getAllPatients();
		assertNotNull(patients);
		for(Patient p : patients){
			System.out.println(String.format("Patient No.%s - %s", p.getId(),p.getFirstName()));
		}
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
	