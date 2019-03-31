package org.akj.springboot.vault.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${username}")
	private String userName;

	@Value("${password}")
	private String password;

	@GetMapping("/")
	@ResponseBody
	public Map<String, String> test() {
		Map<String, String> rsp = new HashMap<String, String>();

		rsp.put("userName", userName);
		rsp.put("password", password);

		return rsp;
	}

}
