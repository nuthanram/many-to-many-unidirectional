package com.ty.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	private String name;
	@Id
	private long phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
