package com.consultorio.core.dataaccess.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.consultorio.core.dataaccess.entity.Address;
import com.consultorio.core.dataaccess.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>  {
	
	List<Patient> findPatientByAddress(Address address);

}
