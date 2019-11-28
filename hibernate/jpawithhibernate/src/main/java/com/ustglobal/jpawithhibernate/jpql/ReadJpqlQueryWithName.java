package com.ustglobal.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ReadJpqlQueryWithName {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="select pname from ProductInfo";
		Query query=entityManager.createQuery(jpql);
		List <String> li=query.getResultList();
		for(String productInfo:li) {
			System.out.println(productInfo);
		}
	}
}
