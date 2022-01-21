package com.example.demo.domains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Drones {
	private List<Drone> drones = new ArrayList<Drone>();

	@Autowired
	private AutowireCapableBeanFactory factory;

	private <T> T createAutowiredObject(Class<T> c) {
		return factory.createBean(c);
	}

	public Drones(ArrayList<Drone> drones) {
		this.drones = drones;
	}

	public void setDrones(int amounts) {
		for (int i = 0; i < amounts; i++) {
			Drone drone = createAutowiredObject(Drone.class);
			drones.add(drone);
		}
	}

	public void getEmpty() {
		Iterator<Drone> drone_iterator = drones.iterator();
		while (drone_iterator.hasNext()) {
			Drone target_drone = drone_iterator.next();
			target_drone.getEmpty();
		}
	}

	public List getId() {
		Iterator<Drone> drone_iterator = drones.iterator();
		List ids = new ArrayList();
		while (drone_iterator.hasNext()) {
			Drone target_drone = drone_iterator.next();
			ids.add(target_drone.getId());
		}
		return ids;
	}

	public int getLength() {
		return drones.size();
	}
}
