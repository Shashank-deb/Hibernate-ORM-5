package com.bsl.tester;



import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCoursesDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		
		
		//get the instructor from db
		int theId=1;
		Instructor tempInstructor=session.get(Instructor.class, theId);
		
		
		//create some courses
		Course tempCourse1=new Course("Air Guitar-The Ultimate Guide");
		
		Course tempCourse2=new Course("The Pinball Masterclass");
		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		
		//save the courses
		
	    session.save(tempCourse1);
	    
	    session.save(tempCourse2);
		
	
		session.beginTransaction();
        
		

		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
