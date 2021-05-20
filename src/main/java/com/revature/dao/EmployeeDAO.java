package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {
//
	public boolean addEmployee(Employee e);
	public boolean removeEmployee(Employee e);
	public List<Employee> getListOfEmployee();
	public Employee findById(int id);
	public double[] getAvgAndSum();
}
