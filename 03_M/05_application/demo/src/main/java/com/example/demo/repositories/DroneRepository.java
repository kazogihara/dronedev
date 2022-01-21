package com.example.demo.repositories;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DroneRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public DroneRepository() {
		
	}
	
	public int getEmpty() {
		Map<String, Object> result = jdbcTemplate
				.queryForMap("SELECT id FROM drone WHERE reserved=0 LIMIT 1 FOR UPDATE");
		jdbcTemplate.update("UPDATE drone SET reserved=1 WHERE id=?", result.get("id"));
		return (int)result.get("id");
	}
}
