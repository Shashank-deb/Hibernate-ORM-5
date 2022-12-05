package com.bsl.tester;



import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetInstructorDetailDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		
		
		Instructor tempInstructor=new Instructor("Susan", "Public", "susan.public@luv2code.com");
		
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","Video Games");
		
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		
	
		session.beginTransaction();
        
		System.out.println("Saving Instructor: "+tempInstructor);
		session.save(tempInstructor);
		

		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
