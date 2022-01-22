package com.example.demo.services;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;

=======
>>>>>>> b2515761055b216197c8d00cbbc583d602f73f08
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.domains.Drones;
import com.example.demo.domains.Reserve;
import com.example.demo.domains.UserAccount;

@Service
@ComponentScan("com.example.demo.domains")
public class ReserveService {
<<<<<<< HEAD
	private int amounts;

	@Autowired
	private UserAccount user_account;
	@Autowired
	private Drones drones;
	@Autowired
	private Reserve reserve;
=======
	private UserAccount user_account;
	private int amounts;
	
	@Autowired
	Drones drones;
	@Autowired
	Reserve reserve;
>>>>>>> b2515761055b216197c8d00cbbc583d602f73f08
	
	
	public void setReserveService(UserAccount user_account,int amounts) {
		this.user_account=user_account;
		this.amounts = amounts;
	}
<<<<<<< HEAD

	public void setUserAccount(UserAccount user_account) {
		this.user_account.setId(user_account.getId());
	}
=======
>>>>>>> b2515761055b216197c8d00cbbc583d602f73f08
	
	public void createReserve() {
		drones.setDrones(amounts);
		drones.getEmpty();
		reserve.setDrones(drones);
		reserve.setUserAccount(user_account);
		reserve.createReserve();
	}
<<<<<<< HEAD
	
	public List<Map<String, Object>> getReserveList() {
		reserve.setUserAccount(this.user_account);
		return reserve.getReserveList();
	}


=======
>>>>>>> b2515761055b216197c8d00cbbc583d602f73f08
}
