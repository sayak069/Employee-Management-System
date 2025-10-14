package com.wipro.factory;

import com.wipro.service.EmployeeServiceImpl;
import com.wipro.service.IEmployeeService;

public class EmployeeServiceFactory {
	private static IEmployeeService empservice;
	static {
		empservice=new EmployeeServiceImpl();
	}
	public static IEmployeeService getEmployeeService() {
		return empservice;
	}
}
