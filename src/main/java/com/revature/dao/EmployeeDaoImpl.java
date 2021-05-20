package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtils;

public class EmployeeDaoImpl implements EmployeeDAO{

	@Override
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()){
			
			String sql = "insert into employees(f_name, l_name, roles_id)"
					+ "values(?,?,?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//Adds the first name variable from the Employee object to the first "?" of our prepared statement
			statement.setString(1, e.getFirstName()); 
			statement.setString(2, e.getLastName());
			statement.setInt(3, e.getRoleId()); //Since roleID is an integer you must use setInt() instead
			
			statement.execute();
			
			return true;
			
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeEmployee(Employee e) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()){
			
			String sql = "Delete from employees where employees_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, e.getId());
			
			statement.execute();
			
			return true;
			
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Employee> getListOfEmployee() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()){
			
			String sql = "select * from employees";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Employee> empList = new ArrayList<Employee>();
			
			while(result.next())
			{
				Employee e = new Employee (
						result.getInt("employees_id"),
						result.getString("f_name"),
						result.getString("l_name"),
						result.getInt("roles_id")
				);
				
				empList.add(e);
			}
			
			return empList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		//This method will find an employee based on the id you provide
		try (Connection conn = ConnectionUtils.getConnection()){
			
			String sql = "select * from employees where employees_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id); //Inputs id value into the first "?"
			
			ResultSet result = statement.executeQuery();
			
			result.next(); //Gets the first row from our select statement
			
			Employee e = new Employee(
					result.getInt("employees_id"),
					result.getString("f_name"),
					result.getString("l_name"),
					result.getInt("roles_id")
			);
			
			return e;
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public double[] getAvgAndSum() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()){
			
			String sql = "select * from get_avg_and_sum()";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			result.next(); //Gets the first row of our table
			
			return new double[] {result.getDouble("avg_salary"), result.getDouble("sum_salary")};
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}


}
