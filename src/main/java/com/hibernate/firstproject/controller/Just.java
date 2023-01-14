package com.hibernate.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Just {

	@GetMapping("/name")
	public String name() {
		System.out.println("name is started...");
		return "name";
	}
}
