package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@RestController
public class MainController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@GetMapping("/")
	public String landing() {
		return "Welcome!";
	}
	@GetMapping("/listdrones")
	public String listdrones() {
		List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from drone");
        return list.toString();
	}
	@PostMapping("/register")
	public String register(@RequestBody String req_param) {
		JSONObject  jObject = new JSONObject(req_param);
		String name = jObject.getString("name");
		int result = jdbcTemplate.update("INSERT INTO drone(name) VALUES(?);",name);
		return String.valueOf(result);
	}
	@DeleteMapping("/deleteregister")
	public String deleteRegister(@RequestBody String req_param) {
		JSONObject  jObject = new JSONObject(req_param);
		String id = jObject.getString("id");
		int result = jdbcTemplate.update("DELETE FROM drone WHERE id=?",Integer.parseInt(id));
		return String.valueOf(result);
	}
	@PutMapping("/updateregister")
	public String updateRegister(@RequestBody String req_param) {
		JSONObject  jObject = new JSONObject(req_param);
		String id = jObject.getString("id");
		String name = jObject.getString("name");
		int result = jdbcTemplate.update("UPDATE drone SET name=? WHERE id=?",name,Integer.parseInt(id));
		return String.valueOf(result);
	}
}