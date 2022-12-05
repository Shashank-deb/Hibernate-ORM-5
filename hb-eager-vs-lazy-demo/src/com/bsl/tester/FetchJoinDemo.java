package com.bsl.tester;

import com.bsl.entity.Instructor;
import com.bsl.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FetchJoinDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		session.beginTransaction();
		// option 2: Hibernate query with HQL

		// get the instructor from db

		int theId = 1;

		Query<Instructor> query = session.createQuery(
				"select i from instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId",
				Instructor.class);
		// set parameter on query

		query.setParameter("theInstructorId", theId);

		// execute query and get Instructor

		Instructor tempInstructor = query.getSingleResult();

		System.out.println("luv2code: Instructor: " + tempInstructor);

		// commit transaction
		session.getTransaction().commit();

		System.out.println("luv2code: Done!");

		session.close();
	}

}
