package com.bsl.tester;

import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteInstructorDetailDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		session.beginTransaction();
		int theId = 3;
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
		System.out.println("the associated instructor: " + tempInstructorDetail);

		System.out.println("Deleting tempInstructor: " + tempInstructorDetail);

		// remove the associated object reference
		// break bi-directional link

		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		
		session.delete(tempInstructorDetail);

		session.getTransaction().commit();

		System.out.println("Done!");

		session.close(); 
	}

}
