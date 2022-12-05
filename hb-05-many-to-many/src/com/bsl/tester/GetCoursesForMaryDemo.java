package com.bsl.tester;



import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.entity.Review;
import com.bsl.entity.Student;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetCoursesForMaryDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

	    //transaction start
		session.beginTransaction();
		
		//get the student mary from database
		int studentId=2;
		
		Student tempStudent=session.get(Student.class, studentId);
		
		System.out.println("\nLoaded student: "+tempStudent);
		
		System.out.println("Courses: "+tempStudent.getCourses());
		
		
		
		//commit transaction
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
