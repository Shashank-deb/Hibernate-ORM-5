package com.bsl.tester;



import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.entity.Review;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseAndReviewsDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		
		
		
		
		
		
		
	
		session.beginTransaction();
		
		
		//create a course
		
		Course tempCourse=new Course("Pacman-How to Score One Million Points");
		
		//add some reviews
		
		tempCourse.addReview(new Review("Great course... loved it!"));
		tempCourse.addReview(new Review("Cool course... job well done!"));
		tempCourse.addReview(new Review("What a dumb course... you are an idot!"));
		
		
		
		//save the course... and leverage the cascade all
        
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		
		session.save(tempCourse);

		//commit transaction
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
