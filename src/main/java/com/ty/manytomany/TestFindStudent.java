package com.ty.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestFindStudent {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Student s");
		List<Student> students=query.getResultList();
		for (Student student : students) {
			System.out.println("*************");
			System.out.print(student.getId()+"   ");
			System.out.print(student.getName()+"   ");
			System.out.println(student.getAge());
			System.out.println("-------------");
			List<Course> courses=student.getCourse();
			for (Course course : courses) {
				System.out.print(course.getName()+"    ");
				System.out.println(course.getDuration());
			}
			System.out.print("*************");
		}
	}
}
