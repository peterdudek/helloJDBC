package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeService {
	private EmployeeDAO eDao = new EmployeeDaoImpl();
	
	public boolean addEmployee(Employee e)
	{
		//Main we have service class is to add any business logic you want
		return eDao.addEmployee(e);
	}
	
	public String removeEmployee(Employee e)
	{
		if(eDao.removeEmployee(e))
		{
			return "Employee was successfully removed from the database!";
		}
		else 
		{
			return "Employee was not successful in removing from the database =(";
		}
	}
	
	public List<Employee> getListOfEmployee()
	{
		return eDao.getListOfEmployee();
	}
	
	public Employee findById(int id)
	{
		return eDao.findById(id);
	}
	
	public String getAvgAndSum()
	{
		double[] avgSum = eDao.getAvgAndSum();
		
		return String.format("Average of Employee's salary: $%.2f"
				+ "\nSum of Employee's salary: $%.2f", avgSum[0], avgSum[1]);
		
	}
}
