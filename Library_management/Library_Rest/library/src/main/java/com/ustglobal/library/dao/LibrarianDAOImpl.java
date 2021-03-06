package com.ustglobal.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.library.dto.BookInventoryBean;
import com.ustglobal.library.dto.BranchBean;
import com.ustglobal.library.dto.UserBean;
import com.ustglobal.library.exception.LibraryManagementException;

@Repository
public class LibrarianDAOImpl implements LibrarianDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean addBookInventory(BookInventoryBean bookInventory) throws LibraryManagementException {
		EntityManager entityManager=factory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(bookInventory);
			entityTransaction.commit();
			return true;
		}catch (Exception e) {
			throw new LibraryManagementException("Failed to add book");
			
		}
	}

	@Override
	public boolean updateBookInventory(BookInventoryBean bookInventory) throws LibraryManagementException {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		BookInventoryBean bookInventoryBean=manager.find(BookInventoryBean.class,bookInventory.getBook_inventory_id());
		try {
		bookInventoryBean.setAuthor(bookInventory.getAuthor());
		bookInventoryBean.setBook_name(bookInventory.getBook_name());
		bookInventoryBean.setCount(bookInventory.getCount());
		bookInventoryBean.setPrice(bookInventory.getPrice());
		transaction.commit();
		return true;
	}catch(Exception e) {
		throw new LibraryManagementException("Failed to update the book");
	}
	}

	@Override
	public boolean deleteBookInventory(int book_inventory_id) throws LibraryManagementException {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		BookInventoryBean bookInventoryBean=manager.find(BookInventoryBean.class,book_inventory_id);
		try {
		manager.remove(bookInventoryBean);
		transaction.commit();
		return true;
		}catch(Exception e) {
			throw new LibraryManagementException("Failed to delete the book");
		}
	}
	
	@Override
	public List<BookInventoryBean> getAll() throws LibraryManagementException {
		EntityManager entityManager=factory.createEntityManager();
		String jpql="from BookInventoryBean";
		TypedQuery<BookInventoryBean> query=entityManager.createQuery(jpql,BookInventoryBean.class);
		List<BookInventoryBean> bookInventory=query.getResultList();
		try {
		return bookInventory;
		}catch(Exception e) {
			throw new LibraryManagementException("Failed to get all the book");
		}
	}

	@Override
	public BookInventoryBean getBookData(int book_inventory_id) throws LibraryManagementException {
		EntityManager entityManager=factory.createEntityManager();
	BookInventoryBean bean=entityManager.find(BookInventoryBean.class,book_inventory_id);
	try {
		return bean;
	}catch (Exception e) {
		throw new LibraryManagementException("failed to get book data");
	}
	
	}
	}
