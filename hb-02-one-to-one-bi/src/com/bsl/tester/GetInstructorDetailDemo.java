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

		session.beginTransaction();

		// get the instructor detail object

		int theId = 2;
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
		// print the instructor detail

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor

		try {
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
