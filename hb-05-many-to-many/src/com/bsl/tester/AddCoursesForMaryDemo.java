package com.bsl.tester;



import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.entity.Review;
import com.bsl.entity.Student;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddCoursesForMaryDemo {
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
		
		//create more courses
		
		
		Course tempCourse1=new Course("Rubik's Cube- How to Speed Cube");
		
		Course tempCourse2=new Course("Atari 2600- Game Development");
		
		
		
		//add student to courses
		tempCourse1.addStudent(tempStudent);
		tempCourse2.addStudent(tempStudent);
		
		//save the courses
		
		System.out.println("\nSaving the courses....");
		session.save(tempCourse1);
		session.save(tempCourse2);

		
		//commit transaction
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
