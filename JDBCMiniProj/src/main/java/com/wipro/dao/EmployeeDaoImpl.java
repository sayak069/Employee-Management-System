package com.wipro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.bean.Employee;
import com.wipro.factory.ConnectionFactory;

public class EmployeeDaoImpl implements IEmployeeDao {
	public static final String EMP_INSERT_QUERY = "INSERT INTO EMPLOYEES VALUES(?,?,?,?)";
	public static final String EMP_SEARCH_QUERY = "SELECT * FROM EMPLOYEES WHERE ENO=?";
	public static final String EMP_UPDATE_QUERY = "UPDATE EMPLOYEES SET ENAME=?,ESAL=?,EADDR=? WHERE ENO=?";
	public static final String EMP_DELETE_QUERY = "DELETE FROM EMPLOYEES WHERE ENO=?";

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
				pst.setInt(1, emp.getEno());
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
		Connection con = null;
		PreparedStatement pst = null;
		String status = null;
		int ip_eno = emp.getEno();
		try {
			Employee e1 = search(ip_eno);
			if (e1==null) {
				System.out.println("record does not exists");
				status = "Failure in updation";
			} else {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(EMP_UPDATE_QUERY);
				pst.setString(1, emp.getEname());
				pst.setDouble(2, emp.getEsal());
				pst.setString(3, emp.getEaddr());
				pst.setInt(4, emp.getEno());
				int result = pst.executeUpdate();

				if (result == 0) {
					status = "Failure in updation";
				} else {
					status = "Success in updation";
				}
			}
		} catch (Exception e) {
			status = "Failure in updation";
			e.printStackTrace();
		}
		return status;
	}

	public String delete(Integer eno) {
		Connection con = null;
		PreparedStatement pst = null;
		String status = null;
		try {
			Employee e1 = search(eno);
			if (e1==null) {
				System.out.println("record does not exist");
				status = "Failure in deletion";
			} else {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(EMP_DELETE_QUERY);
				pst.setInt(1, eno);
				int result = pst.executeUpdate();

				if (result == 0) {
					status = "Failure in deletion";
				} else {
					status = "Success in deletion";
				}
			}
		} catch (Exception e) {
			status = "Failure in deletion";
			e.printStackTrace();
		}
		return status;
	}

}
