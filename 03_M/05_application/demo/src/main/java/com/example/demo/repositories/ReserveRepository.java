package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String createReserve(int drone_id,int user_account_id) {
		int result = jdbcTemplate.update("INSERT INTO reserve(drone_id,user_account_id) VALUES(?,?)", drone_id,user_account_id);
		return String.valueOf(result);
	}
}
