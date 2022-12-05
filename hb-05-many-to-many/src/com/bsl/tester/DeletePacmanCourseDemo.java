package com.bsl.tester;



import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.entity.Review;
import com.bsl.entity.Student;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeletePacmanCourseDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

	    //transaction start
		session.beginTransaction();
		
		
		//get the pacman course from db
		int courseId=10;
		Course tempCourse=session.get(Course.class, courseId);
		
		
		//delete the course
		System.out.println("Deleting course: "+tempCourse);
		session.delete(tempCourse);
		
		//commit transaction
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
