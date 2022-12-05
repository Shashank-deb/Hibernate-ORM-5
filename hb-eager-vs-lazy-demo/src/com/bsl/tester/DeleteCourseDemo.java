package com.bsl.tester;

import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteCourseDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		session.beginTransaction();

		int theId=10;
		
		
		Course tempCourse = session.get(Course.class, theId);

		
		System.out.println("Deleting course: "+tempCourse);
		
		session.delete(tempCourse);
		
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
