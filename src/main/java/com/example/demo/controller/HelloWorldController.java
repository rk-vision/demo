package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	//@RequestMapping(method = RequestMethod.GET,value = "/hello-world")
	@GetMapping(value = "/hello-world")
	public String getHelloWorld() {
		return "JAI MATA DI....";
	}
	
	@GetMapping(value = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("BEan se Hiii");
	}
	
	@GetMapping(value = "/hello-world/path-variable/{name}")
	public String getHelloWorldPathVariable(@PathVariable String name) {
		return String.format("JAI MATA DI....,%s",name);
	}

}
