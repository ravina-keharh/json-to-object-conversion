package com.example.json;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

//@SpringBootApplication
public class JsonApplication {

	//@Autowired
	//private ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			App app = mapper.readValue(new File("src/main/resources/data.json"), App.class);
			String s = mapper.writeValueAsString(app);
			System.out.println(s);
			Employee emp = mapper.readValue(new File("src/main/resources/emp-data.json"), Employee.class);
			System.out.println(emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SpringApplication.run(JsonApplication.class, args);
	}

	
	
}
class App {
	private Object application;

	public Object getApplication() {
		return application;
	}

	public void setApplication(Object application) {
		this.application = application;
	}
}
class Employee {
	private String id;
	private String name;
	private Integer age;
	private EmployeeAddress address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public EmployeeAddress getAddress() {
		return address;
	}
	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		//return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
		return new Gson().toJson(this);
	}
	
} 
class EmployeeAddress {
	private String country;
	private String state;
	private String city;
	private Integer pinCode;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	// not needed toString due to Gson 
	/*
	 * @Override public String toString() { return "EmployeeAddress [country=" +
	 * country + ", state=" + state + ", city=" + city + ", pinCode=" + pinCode +
	 * "]"; }
	 */
}
