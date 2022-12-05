package com.bsl.tester;

import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EagerLazyDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		session.beginTransaction();

		int theId = 1;

		Instructor tempInstructor = session.get(Instructor.class, theId);
		
		System.out.println("luv2code: Instructor: "+tempInstructor);
		
		System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
		

		//commit transaction
		session.getTransaction().commit();
		
		//close the session
		session.close();
		
		
		//since courses are lazy loaded ... this should fail
		
	    System.out.println("luv2code: The session is now closed!\n");
		//option 1: call getter method while session is open
		
		//get courses for the instructor
		System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
		
		System.out.println("luv2code: Done!");

		session.close();
	}

}
