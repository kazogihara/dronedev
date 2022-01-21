package com.example.demo.domains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repositories.DroneRepository;

@Component
public class Drone {
	private int id;
	private String name;

	@Autowired
	DroneRepository drone_repository;

	public Drone(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Drone() {
	}

	public void getEmpty() {
		this.id = drone_repository.getEmpty();
	}

	public int getId() {
		return this.id;
	}
}
