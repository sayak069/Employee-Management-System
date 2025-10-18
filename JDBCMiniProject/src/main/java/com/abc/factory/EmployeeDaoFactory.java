package com.abc.factory;

import com.abc.dao.EmployeeDaoImpl;
import com.abc.dao.IEmployeeDao;

public class EmployeeDaoFactory {
	private static IEmployeeDao empdao;
	static {
		empdao = new EmployeeDaoImpl();
	}

	public static IEmployeeDao getEmployeeDao() {
		return empdao;
	}
}
