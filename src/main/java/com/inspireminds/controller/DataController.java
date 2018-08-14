package com.inspireminds.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspireminds.cache.DataCache;
import com.inspireminds.common.Employee;

@RestController
public class DataController {

	@GetMapping("/api/employees")
	public List<Employee> calculateCcsConversion() {

		
		DataCache.getInstance().add(new Employee("Venkat Muthyala",40,4));
		DataCache.getInstance().add(new Employee("Varun Setlam",20,2));
		DataCache.getInstance().add(new Employee("Anish Muthyala",10,1));
		DataCache.getInstance().add(new Employee("Manish Muthyala",15,1));
		for(int i=0;i<5;i++) {
			DataCache.getInstance().add(new Employee("I am "+i,i+10,i*i));
		}
		return DataCache.getInstance().getEmployees();
	}

	//@DeleteMapping("/api/delete")
	@RequestMapping(value = "/api/delete", method = RequestMethod.POST)
	//@ResponseBody
	public String toDelete(Employee employee) {
	//public String toDelete() {
	//	Employee employee = null;
		System.out.println("delete operation "+employee);
		DataCache.getInstance().remove(employee);
		return "Done";
	}

	@GetMapping("/api/employees1")
	public String doTest() {

		
		return "I am here";
	}
}
