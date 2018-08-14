package com.inspireminds.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inspireminds.common.Employee;

public class DataCache {

	private List<Employee> list = new ArrayList<Employee>();

	private static DataCache dataCache = new DataCache();

	private DataCache() {
	}

	public static DataCache getInstance() {
		return dataCache;
	}

	public void add(Employee employee) {
		list.add(employee);
	}

	public void remove(Employee employee) {
		for(int i=0;i<list.size();i++) {
			Employee currentEmployee = list.get(i);
			if(currentEmployee.compare(employee)) {
				list.remove(i);
				break;
			}
			
		}
		//list.remove(employee);
	}

	public List<Employee> getEmployees() {
		return Collections.unmodifiableList(list);
	}
}
