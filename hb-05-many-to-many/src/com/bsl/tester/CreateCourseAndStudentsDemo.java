package com.bsl.tester;



import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.entity.Review;
import com.bsl.entity.Student;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseAndStudentsDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

	    //transaction start
		session.beginTransaction();
		
		
		//create a course
		
		
		Course tempCourse=new Course("Pacman- How to Score One Million Points");
		
		
		
		//save the course
		
		System.out.println("\nSaving the course...");
		session.save(tempCourse);
		System.out.println("Saved the course: "+tempCourse);
		
		
		
		//create the students
		
		Student tempStudent1=new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2=new Student("Mary","Public","mary@luv2code.com");
		
		
				
		
		//add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		
		
		
		//save the students
		System.out.println("\nSaving students....");
		session.save(tempStudent1);
		session.save(tempStudent2);
		System.out.println("Saved students: "+tempCourse.getStudents());
		

		//commit transaction
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
