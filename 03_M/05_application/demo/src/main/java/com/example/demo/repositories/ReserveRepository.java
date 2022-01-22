package com.example.demo.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domains.UserAccount;

@Repository
public class ReserveRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String createReserve(int drone_id,int user_account_id) {
		int result = jdbcTemplate.update("INSERT INTO reserve(drone_id,user_account_id) VALUES(?,?)", drone_id,user_account_id);
		return String.valueOf(result);
	}

	public List<Map<String, Object>> getReserveList(int user_account_id) {
		return jdbcTemplate.queryForList("SELECT id, drone_id ,user_account_id FROM reserve WHERE user_account_id = ?",user_account_id);
	}
}
