package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudent {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student1=new Student();
		student1.setAge(20);
		student1.setName("swathi");
		Course course1 =entityManager.find(Course.class, 2);
		Course course2 =entityManager.find(Course.class, 1);
		List<Course> courses1=new  ArrayList<Course>();
		courses1.add(course1);
		courses1.add(course2);
		student1.setCourse(courses1);
		entityTransaction.begin();
		entityManager.persist(student1);
		entityTransaction.commit();
		System.out.println("done");
	}
}
