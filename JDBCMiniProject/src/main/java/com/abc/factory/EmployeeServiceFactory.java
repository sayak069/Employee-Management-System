package com.abc.factory;

import com.abc.service.EmployeeServiceImpl;
import com.abc.service.IEmployeeService;

public class EmployeeServiceFactory {
	private static IEmployeeService empservice;
	static {
		empservice=new EmployeeServiceImpl();
	}
	public static IEmployeeService getEmployeeService() {
		return empservice;
	}
}
