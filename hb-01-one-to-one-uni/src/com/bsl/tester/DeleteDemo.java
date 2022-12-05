package com.bsl.tester;

import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.utils.SessionFactoryUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {
	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtils.getSf();

		Session session = factory.openSession();

		
		
		

		session.beginTransaction();
		
		
		int theId=1;
		
		Instructor tempInstructor=session.get(Instructor.class, theId);
		
        System.out.println("Found instructor: "+tempInstructor);
        
        //delete the instructors
        
        if (tempInstructor!=null) {
		    System.out.println("Deleting: "+tempInstructor);
            //Note : will also delete associated "details " object
		    //because of CascadeType.ALL
		    session.delete(tempInstructor);
		}
		
		session.getTransaction().commit();

		System.out.println("Done!");

		session.close();
	}

}
