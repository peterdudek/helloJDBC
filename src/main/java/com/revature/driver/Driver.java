package com.revature.driver;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class Driver {
	
	
	public static void main(String[] args)
	{
		EmployeeService empServ = new EmployeeService();
		Employee emp1 = new Employee(10,"Stephen", "Padilao", 3);
		
//		System.out.println(empServ.addEmployee(emp1));
		
//		System.out.println(empServ.removeEmployee(emp1));
		
//		for (Employee emp : empServ.getListOfEmployee()) {
//			
//			System.out.println(emp);
//			
//		}
		
//		System.out.println(empServ.findById(9));
		
		System.out.println(empServ.getAvgAndSum());
		
	}
}
