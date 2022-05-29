package com.example.Hibernatedemo;

import org.hibernate.Session;

import com.example.dto.EmployeeEntity;

public class TestHibernate {
	
	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//	ADD EMPLOYEE OBJECT
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("yo@mail.com");
		emp.setFirstName("yo merengues");
		emp.setLastName("yoooo");
		
		session.save(emp);
		
		session.getTransaction().commit();
		//HibernateUtil.shutdown();
	}

}
