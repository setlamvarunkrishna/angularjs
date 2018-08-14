package com.inspireminds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspireminds.cache.DataCache;
import com.inspireminds.common.Employee;

@Controller
public class HomeController {
 
	private static int counter = 1;
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
    
    
    @RequestMapping(value = "/logout")
    //@RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
    	DataCache.getInstance().add(new Employee("Log out "+counter++,15,1));
        return "index.html";
    }
}
