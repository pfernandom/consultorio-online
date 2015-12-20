package com.consultorio.core.services.impl;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.consultorio.core.dataaccess.entity.Patient;
import com.consultorio.core.dataaccess.repo.PatientRepository;
import com.consultorio.core.exceptions.ElementNotPersistedException;
import com.consultorio.core.exceptions.PatientNotFoundException;
import com.consultorio.core.services.PatientService;



@Component
@Qualifier("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepo;
	
	@Override
	public List<Patient> getAllPatients() {
		Iterable<Patient> patients = patientRepo.findAll();
		if(patients!=null){
			return IteratorUtils.toList(patients.iterator()); 
		}
		else{
			throw new PatientNotFoundException();
		}
	}

	@Override
	public Patient createPatient(Patient patient) {
		try{
			Patient result = patientRepo.save(patient);
			Assert.notNull(result);
			return result;
		}catch(Exception e){
			throw new ElementNotPersistedException(e);
		}
	}

	@Override
	public Patient getPatientById(Long id) {
		try{
			Patient result = patientRepo.findOne(id);
			Assert.isNull(result);
			return result;
			
		}catch(Exception e){
			throw new ElementNotPersistedException(e);
		}
	}

	@Override
	public void deletePatientById(Long id) {
		try{
			patientRepo.delete(id);
			
		}catch(Exception e){
			throw new ElementNotPersistedException(e);
		}
	}

	@Override
	public void deletePatient(Patient patient) {
		try{
			patientRepo.delete(patient);
			
		}catch(Exception e){
			throw new ElementNotPersistedException(e);
		}

	}

	@Override
	public Boolean isPatientExist(Patient patient) {
		try{
			Patient result = patientRepo.findOne(patient.getId());
			if(result!=null){
				return true;
			}
			else{
				return false;
			}
			
		}catch(Exception e){
			throw new ElementNotPersistedException(e);
		}
	}

	@Override
	public void deleteAllPatients() {
		patientRepo.deleteAll();
	}

}
