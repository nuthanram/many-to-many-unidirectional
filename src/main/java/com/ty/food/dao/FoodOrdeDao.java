package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrdeDao {
	public FoodOrder saveOrder(FoodOrder fo,Item... items) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(fo);
		for (Item item : items) {
			item.setFoodOrder(fo);
			entityManager.persist(item);
		}
		entityTransaction.commit();
		return fo;
	}
	public FoodOrder getOrderById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(FoodOrder.class, id);
	}
	public List<FoodOrder> getAllOrders(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select f from FoodOrder f");
		return query.getResultList();
	}
	public boolean deleteOrder(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		FoodOrder fo=entityManager.find(FoodOrder.class, id);
		if(fo!=null) {
			entityTransaction.begin();
			entityManager.persist(fo);
			entityTransaction.commit();
			return true;
		}
		else {
			System.out.println("order doesnt exist");
			return false;
			
		}
	}
}
