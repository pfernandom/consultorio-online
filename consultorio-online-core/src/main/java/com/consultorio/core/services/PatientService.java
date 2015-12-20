package com.consultorio.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.consultorio.core.dataaccess.entity.Patient;

public interface PatientService {
	List<Patient> getAllPatients();
	Patient createPatient(Patient patient);
	Patient getPatientById(Long id);
	void deletePatientById(Long id);
	void deletePatient(Patient patient);
	void deleteAllPatients();
	Boolean isPatientExist(Patient patient);
	
}
