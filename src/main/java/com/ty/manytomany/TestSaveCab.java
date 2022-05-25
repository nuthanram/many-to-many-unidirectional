package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCab {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Cab cab=new Cab();
		cab.setDrivername("naresh kumar");
		cab.setCost(600);
		Person person1=new Person();
		person1.setName("stalin");
		person1.setPhone(9856235698l);
		Person person2=new Person();
		person2.setName("charan");
		person2.setPhone(8545625698l);
		Person person3=new Person();
		person3.setName("arjuna");
		person3.setPhone(6366235231l);
		List<Person> persons=new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		cab.setPerson(persons);
		entityTransaction.begin();
		entityManager.persist(cab);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityTransaction.commit();
		System.out.println("done");
	}
}
