package com.example.demo.domains;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repositories.ReserveRepository;

@Component
public class Reserve {
	@Autowired
	ReserveRepository reserve_repository;
	@Autowired
	private Drones drones;
	@Autowired
	private UserAccount user_account;

	public void setDrones(Drones drones) {
		this.drones = drones;
	}

	public void setUserAccount(UserAccount user_account) {
		this.user_account = user_account;
	}

	public void createReserve() {
		List ids = drones.getId();
		ids.forEach(id -> reserve_repository.createReserve((int)id, user_account.getId()));
	}
}
