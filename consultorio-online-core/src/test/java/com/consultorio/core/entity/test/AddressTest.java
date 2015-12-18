package com.consultorio.core.entity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.consultorio.core.dataaccess.repo.AddressRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/app-context.xml")
@ActiveProfiles("application")
public class AddressTest {

	@Autowired
	AddressRepository addressRepo;
	
	@Test
	public void test() {
		assertEquals(0,addressRepo.count());
	}

}
