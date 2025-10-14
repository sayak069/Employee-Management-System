package com.wipro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.bean.Employee;
import com.wipro.factory.ConnectionFactory;

public class EmployeeDaoImpl implements IEmployeeDao {
	public static final String EMP_INSERT_QUERY = "INSERT INTO EMPLOYEES VALUES(?,?,?,?)";
	public static final String EMP_SEARCH_QUERY = "SELECT * FROM EMPLOYEES WHERE ENO=?";
	public static final String EMP_UPDATE_QUERY1 = "UPDATE EMPLOYEES SET ENAME=? WHERE ENO=?";
	public static final String EMP_UPDATE_QUERY2 = "UPDATE EMPLOYEES SET ESAL=? WHERE ENO=?";
	public static final String EMP_UPDATE_QUERY3 = "UPDATE EMPLOYEES SET EADDR=? WHERE ENO=?";

	public String add(Employee emp) {
		Connection con = null;
		PreparedStatement pst = null;
		String status = null;
		int ip_eno = emp.getEno();
		try {
			Employee e1 = search(ip_eno);
			if (e1!=null) {
				System.out.println("record already exists");
				status = "Failure in insertion";
			} else {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(EMP_INSERT_QUERY);
				pst.setInt(1, ip_eno);
				pst.setString(2, emp.getEname());
				pst.setDouble(3, emp.getEsal());
				pst.setString(4, emp.getEaddr());
				int result = pst.executeUpdate();

				if (result == 0) {
					status = "Failure in insertion";
				} else {
					status = "Success in insertion";
				}
			}
		} catch (Exception e) {
			status = "Failure in insertion";
			e.printStackTrace();
		}
		return status;
	}

	public Employee search(Integer eno) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Employee e1 = new Employee();
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(EMP_SEARCH_QUERY);
			pst.setInt(1, eno);
			rs = pst.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					e1.setEno(rs.getInt(1));
					e1.setEname(rs.getString(2));
					e1.setEsal(rs.getDouble(3));
					e1.setEaddr(rs.getString(4));
				} else {
					e1 = null;
				}
			}
		} catch (Exception e) {
			e1 = null;
			e.printStackTrace();
		}
		return e1;
	}

	public String update(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete(Integer eno) {
		// TODO Auto-generated method stub
		return null;
	}

}
