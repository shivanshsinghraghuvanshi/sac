package com.ilab.safety.sac.controllers;

import com.ilab.safety.sac.sample.NestedTester;
import com.ilab.safety.sac.sample.OuterClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SacAuthenticationController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}