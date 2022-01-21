package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.domains.Drones;
import com.example.demo.domains.Reserve;
import com.example.demo.domains.UserAccount;

@Service
@ComponentScan("com.example.demo.domains")
public class ReserveService {
	private UserAccount user_account;
	private int amounts;
	
	@Autowired
	Drones drones;
	@Autowired
	Reserve reserve;
	
	
	public void setReserveService(UserAccount user_account,int amounts) {
		this.user_account=user_account;
		this.amounts = amounts;
	}
	
	public void createReserve() {
		drones.setDrones(amounts);
		drones.getEmpty();
		reserve.setDrones(drones);
		reserve.setUserAccount(user_account);
		reserve.createReserve();
	}
}
