package com.consultorio.core.entity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.consultorio.core.dataaccess.repo.AddressRepository;
import com.consultorio.core.dataaccess.repo.DiseaseRepository;
import com.consultorio.core.dataaccess.repo.PatientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/app-context.xml")
@ActiveProfiles("application")
public class PatientTest {
	//
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	DiseaseRepository diseaseRepo;
	
	private Address address;
	private Disease disease;
	
	@Before
	public void setUp() throws Exception {
		address = new Address();
		address.setStreet("4701 Staggerbrush Rd");
		address.setCity("Austin");
		address.setState("Texas");
		
		disease = new Disease();
		disease.setCode("D123456789");
		disease.setName("Diabetes");
		disease.setType("DM1");
		diseaseRepo.save(disease);
	}
	
	@After
	public void tearDown() throws Exception {
		
		System.out.println("Before "+diseaseRepo.count());
		patientRepo.deleteAll();
		addressRepo.deleteAll();
		//diseaseRepo.deleteAll();
		System.out.println(diseaseRepo.count());
	}

	@Test
	public void testIsServiceUp() {
		assertEquals(0,patientRepo.count());
	}
	
	@Test
	public void testSavePatient() {
		Patient patient = new Patient();
		patient.setName("Pedro");
		patient.setGender(Gender.MALE);
		patient.setAddress(address);
		
		
		HeredoFamilyBackground familyBackground = new HeredoFamilyBackground();
		familyBackground.addDisease(disease);
		
		patient.setHereditaryFamilyBackground(familyBackground);
		
		patient = patientRepo.save(patient);
		
		System.out.println(patient);
		
		assertEquals(1,patientRepo.count());
		System.out.println(patient);
	}
	
	@Test
	public void testGetPatientsByAddress() {
		Patient patient = new Patient();
		patient.setName("Pedro");
		patient.setAddress(address);
		
		patientRepo.save(patient);
		
		assertEquals(1,patientRepo.count());
		
		Address searchAddress = addressRepo.findAll().iterator().next();
		assertNotNull(searchAddress);
		assertEquals(address.getState(),searchAddress.getState());
		
		List<Patient> patients = patientRepo.findPatientByAddress(searchAddress);
		assertNotNull(patients);
		assertFalse(patients.isEmpty());
		Patient foundPatient =patients.get(0);
		
		assertEquals(patient.getName(),foundPatient.getName());
	}
	
	

}
