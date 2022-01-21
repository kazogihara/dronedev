package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String isAccountExists(int account_id) {
		int result = jdbcTemplate.update("SELECT COUNT(*) FROM user_account WHERE id=?", account_id);
		return Integer.toString(result);
	}
}
