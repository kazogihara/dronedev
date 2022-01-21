package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domains.UserAccount;
import com.example.demo.services.ReserveService;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@RestController
public class MainController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ReserveService reserve_service;
	@Autowired
	UserAccount user_account;

	@GetMapping("/")
	public String landing() {
		return "Welcome!";
	}

	@GetMapping("/listdrones")
	public String listdrones() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from drone");
		return list.toString();
	}

	@PostMapping("/register")
	public String register(@RequestBody String req_param) {
		JSONObject jObject = new JSONObject(req_param);
		String name = jObject.getString("name");
		int result = jdbcTemplate.update("INSERT INTO drone(name) VALUES(?);", name);
		return String.valueOf(result);
	}

	@DeleteMapping("/deleteregister")
	public String deleteRegister(@RequestBody String req_param) {
		JSONObject jObject = new JSONObject(req_param);
		String id = jObject.getString("id");
		int result = jdbcTemplate.update("DELETE FROM drone WHERE id=?", Integer.parseInt(id));
		return String.valueOf(result);
	}

	@PutMapping("/updateregister")
	public String updateRegister(@RequestBody String req_param) {
		JSONObject jObject = new JSONObject(req_param);
		String id = jObject.getString("id");
		String name = jObject.getString("name");
		int result = jdbcTemplate.update("UPDATE drone SET name=? WHERE id=?", name, Integer.parseInt(id));
		return String.valueOf(result);
	}

	@GetMapping("/rtl")
	public String rtl() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8000/rtl", HttpMethod.GET, entity, String.class).getBody();
	}

	@PostMapping("/reserve")
	public String reserve(@RequestBody String req_param) {
		System.out.println(req_param);
		JSONObject jObject = new JSONObject(req_param);
		int user_account_id=jObject.getInt("user_account");
		int amounts = jObject.getInt("amounts");
		user_account.setId(user_account_id);
		reserve_service.setReserveService(user_account, amounts);
		reserve_service.createReserve();
		return "0";
	}
}