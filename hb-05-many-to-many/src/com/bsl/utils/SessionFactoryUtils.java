package com.bsl.utils;

import com.bsl.entity.Course;
import com.bsl.entity.Instructor;
import com.bsl.entity.InstructorDetail;
import com.bsl.entity.Review;
import com.bsl.entity.Student;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtils {

	private static SessionFactory sf = null;

	public static SessionFactory getSf() {
		if (sf == null) {
			Configuration con = new Configuration().configure().addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class);
			
			
			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
			sf = con.buildSessionFactory(reg);
		}
		return sf;
	}

}
