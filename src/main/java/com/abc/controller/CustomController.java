package com.abc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

	@RequestMapping(value = "/welcome/{customer}", method = RequestMethod.POST)
	public ResponseEntity<String> welcomeUser(@PathVariable("customer") String customer) {
		System.out.println("Inside welcomeUser in controller");
		return new ResponseEntity<String>("Welcome " + customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {

		System.out.println("Welcome called Login");
		return "welcome";
	}

}
