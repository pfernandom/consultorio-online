package com.consultorio.core.dataaccess.repo;

import org.springframework.data.repository.CrudRepository;

import com.consultorio.core.dataaccess.entity.Disease;

public interface DiseaseRepository extends CrudRepository<Disease, Long>  {
	
}
