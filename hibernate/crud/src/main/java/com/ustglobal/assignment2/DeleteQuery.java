package com.ustglobal.assignment2;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.assignment2.dto.Student;
public class DeleteQuery {
	public static void main(String[] args) {
		EntityManager entityManager=null;
		EntityTransaction entityTransaction=null;


		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test1");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			Student info=entityManager.find(Student.class, 1);
			entityManager.remove(info);
			System.out.println("Record Deleted");
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}
}


