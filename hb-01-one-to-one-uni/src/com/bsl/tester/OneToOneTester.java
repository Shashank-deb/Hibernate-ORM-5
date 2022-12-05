package com.bsl.tester;


import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneTester {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		
		
		
//		
//		Instructor tempInstructor=new Instructor("Shashank","Sharma","sharmashashank446@gmail.com");
//		
//		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.com","Luv 2 code!!!");

		
		
		Instructor tempInstructor=new Instructor("Madhu", "Patel", "madhu@luv2code.com");
		
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com", "Guitar");
		//associate the objects
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		
		session.beginTransaction();
		
		
		System.out.println("Saving instructor: "+tempInstructor);
		
		session.save(tempInstructor);

		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
