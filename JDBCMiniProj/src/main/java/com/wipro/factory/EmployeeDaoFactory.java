package com.wipro.factory;

import com.wipro.dao.EmployeeDaoImpl;
import com.wipro.dao.IEmployeeDao;

public class EmployeeDaoFactory {
	private static IEmployeeDao empdao;
	static {
		empdao = new EmployeeDaoImpl();
	}

	public static IEmployeeDao getEmployeeDao() {
		return empdao;
	}
}
