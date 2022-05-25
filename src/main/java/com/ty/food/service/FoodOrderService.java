package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dao.FoodOrdeDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderService {
	public FoodOrder saveOrder(FoodOrder fo,Item... items) {
		FoodOrdeDao dao=new FoodOrdeDao();
		return dao.saveOrder(fo,items);
	}
	public FoodOrder getOrderById(int id) {
		FoodOrdeDao dao=new FoodOrdeDao();
		return dao.getOrderById(id);
	}
	public List<FoodOrder> getAllOrders(){
		FoodOrdeDao dao=new FoodOrdeDao();
		return dao.getAllOrders();
	}
	public boolean deleteOrder(int id) {
		FoodOrdeDao dao=new FoodOrdeDao();
		return dao.deleteOrder(id);
	}
}
