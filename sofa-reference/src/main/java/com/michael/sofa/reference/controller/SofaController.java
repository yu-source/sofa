package com.michael.sofa.reference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.sofa.service.IHelloService;

@RestController
public class SofaController {

	@Autowired
	private IHelloService helloService;
	
	@RequestMapping("sayHello")
	public String sayHello() {
		return helloService.sayHello("Michael");
	}
}
