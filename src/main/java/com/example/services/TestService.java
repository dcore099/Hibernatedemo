package com.example.services;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeEntity;

@Service
public class TestService {
	final static Logger logger = Logger.getLogger(TestService.class);
	
	@Autowired
	SessionFactory factory;
	
	public void test() {
		logger.info("INICIANDO TEST EN TESTSERVICE.CLASS");
		
		if (factory == null) {
			logger.info("Factory is not initialized");
		}else {
			Session session = factory.openSession();
			session.beginTransaction();
			
			//	ADD EMPLOYEE OBJECT
			EmployeeEntity emp = new EmployeeEntity();
			emp.setEmail("yo@mail.com");
			emp.setFirstName("yo merengues");
			emp.setLastName("yoooo");
			
			session.save(emp);
			
			session.getTransaction().commit();
			
			//	CLOSE THE FACTORY
			//factory.shutdown();
		}	
		
	}

}
