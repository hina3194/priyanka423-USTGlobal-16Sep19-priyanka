package com.ustglobal.jpawithhibernate;

import java.util.ArrayList;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernate.manytomany.Course;
import com.ustglobal.jpawithhibernate.manytomany.Student;

import java.util.List;

public class TestManyToMany {
	public static void main(String[] args) {

		Course c=new Course();
		c.setCid(10);
		c.setCname("BCA");

		Course c1=new Course();
		c1.setCid(11);
		c1.setCname("MCA");

		ArrayList<Course> alCourses=new ArrayList<Course>();
		alCourses.add(c);
		alCourses.add(c1);

		Student s=new Student();
		s.setSid(1);
		s.setSname("Priya");
		s.setCourses(alCourses);


		EntityManager entityManager=null;
		EntityTransaction entityTransaction=null;

		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			System.out.println("Record Saved");
			//			entityManager.persist(s); // unidirectional

			//bidirectional
			Course corseInfo=entityManager.find(Course.class, 10);
			List<Student> li=corseInfo.getStudents();
			for(Student s3:li) {
				System.out.println(s3.getSid());
				System.out.println(s3.getSname());
			}
			//..........................//
			entityTransaction.commit();

		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}
}
