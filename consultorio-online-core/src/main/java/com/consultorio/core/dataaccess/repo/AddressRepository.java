package com.consultorio.core.dataaccess.repo;

import org.springframework.data.repository.CrudRepository;

import com.consultorio.core.dataaccess.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long>  {

}
