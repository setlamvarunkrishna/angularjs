/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.inspireminds.common;

public class Employee {

	private String name;
	private int age;
	private int years;

	public Employee() {

	}

	public Employee(String name, int age, int years) {
		this.name = name;
		this.age = age;
		this.years = years;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public boolean compare(Employee employee) {
		if (employee == null || employee.getName() == null || employee.getYears() == 0 || employee.getAge() == 0) {
			return false;
		}
		if (employee.getName().equals(this.getName()) && employee.getAge() == this.getAge()
				&& employee.getYears() == this.getYears())
			return true;

		return false;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", years=" + years + "]";
	}
	
	
}
// end::code[]