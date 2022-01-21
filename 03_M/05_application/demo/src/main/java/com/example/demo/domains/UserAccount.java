package com.example.demo.domains;

import org.springframework.stereotype.Component;

@Component
public class UserAccount {
	private int id;
	private String name;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
}
