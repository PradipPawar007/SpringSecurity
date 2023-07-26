package com.securitydemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class Controller {

	
@RequestMapping("/")
public String welcome(){
	return "Welcome to spring Security application";
}

@RequestMapping("/get")
public String sgetData(){
	return "Record get successfully..........!";
}
@RequestMapping("/add")
public String saveData(){
	return "Record Add successfully..........!";
}

@RequestMapping("/update")
public String updateData(){
	return "Record Updated successfully..........!";
}

@RequestMapping("/delete")
public String  deleteData(){
	return "Record Deleted successfully..........!";
}



}
