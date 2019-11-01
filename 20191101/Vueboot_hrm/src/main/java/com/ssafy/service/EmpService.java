package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.Dept;
import com.ssafy.dto.Emp;

public interface EmpService {

	public void deleteEmployee(int id);
	public void addEmployee(Emp emp);
	public void updateEmployee(Emp emp);
	
	public Emp findEmployeeById(int id);
	public List<Emp>  findLikeEmployee(String name);
	public List<Emp> findAllEmployees();
	public List<String> findAllTitles();
	public List<String> findAllDepartment();
	public int getEmployeesTotal();
	
	public Dept findDepartmentEmployees(int id) throws Exception;
	
}
