package com.abc.test;

import java.util.Scanner;

import com.abc.bean.Employee;
import com.abc.factory.EmployeeServiceFactory;
import com.abc.service.IEmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp = new Employee();
		IEmployeeService empService = null;
		String status = null;

		try (Scanner sc = new Scanner(System.in);) {
			int choice = 0;
			int eno = 0;
			String ename = null, eaddr = null;
			double esal = 0.0;

			while (true) {
				System.out.println("\n======================");
				System.out.println("1. insert employee");
				System.out.println("2. search employee");
				System.out.println("3. update employee");
				System.out.println("4. delete employee");
				System.out.println("5. exit");

				System.out.print("enter choice: ");
				choice = sc.nextInt();

				switch (choice) {
				
				case 1:
					System.out.println("====employee add module====");
					System.out.print("enter eno: ");
					eno = sc.nextInt();
					System.out.print("enter ename: ");
					ename = sc.next();
					System.out.print("enter esal: ");
					esal = sc.nextDouble();
					System.out.print("enter eaddr: ");
					eaddr = sc.next();

					emp.setEno(eno);
					emp.setEname(ename);
					emp.setEsal(esal);
					emp.setEaddr(eaddr);

					empService = EmployeeServiceFactory.getEmployeeService();
					status = empService.addEmployee(emp);
					System.out.println(status);
					break;
					
				case 2:
					System.out.println("====employee search module====");
					System.out.print("enter eno: ");
					eno = sc.nextInt();
					empService = EmployeeServiceFactory.getEmployeeService();
					Employee e1=empService.searchEmployee(eno);
					if(e1==null) {
						System.out.println("no records found");
					}else {
						System.out.println("eno= "+e1.getEno());
						System.out.println("ename= "+e1.getEname());
						System.out.println("esal= "+e1.getEsal());
						System.out.println("eaddr= "+e1.getEaddr());
					}
					break;
					
				case 3:
					System.out.println("====employee update module====");
					System.out.print("enter eno: ");
					eno = sc.nextInt();
					System.out.print("enter ename: ");
					ename = sc.next();
					System.out.print("enter esal: ");
					esal = sc.nextDouble();
					System.out.print("enter eaddr: ");
					eaddr = sc.next();
					
					emp.setEno(eno);
					emp.setEname(ename);
					emp.setEsal(esal);
					emp.setEaddr(eaddr);
					
					empService = EmployeeServiceFactory.getEmployeeService();
					status = empService.updateEmployee(emp);
					System.out.println(status);
					break;
					
				case 4:
					System.out.println("====employee delete module====");
					System.out.print("enter eno: ");
					eno = sc.nextInt();
					empService = EmployeeServiceFactory.getEmployeeService();
					status = empService.deleteEmployee(eno);
					System.out.println(status);
					break;
					
				case 5:
					System.out.println("bye");
					System.exit(0);
					break;
					
				default:
					System.out.println("wrong choice");
				}// end of switch
			} // end of while
		} catch (Exception e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of main

}// end of class
