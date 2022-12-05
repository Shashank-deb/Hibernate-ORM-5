package com.bsl.tester;

import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetInstructorCoursesDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		session.beginTransaction();

		int theId = 1;

		Instructor tempInstructor = session.get(Instructor.class, theId);
		
		System.out.println("Instructor: "+tempInstructor);
		
		
		System.out.println("Courses: "+tempInstructor.getCourses());

		
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
