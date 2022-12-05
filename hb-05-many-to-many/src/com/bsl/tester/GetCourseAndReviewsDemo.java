package com.bsl.tester;



import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.entity.Review;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetCourseAndReviewsDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();


	    //start a transaction
		session.beginTransaction();
		
		
		//get the course
		int theId=10;
		Course tempCourse=session.get(Course.class, theId);
		
		//print the course
		
		System.out.println(tempCourse);
		
		//print the course reviews
		
		System.out.println(tempCourse.getReviews());
		

		//commit transaction
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
