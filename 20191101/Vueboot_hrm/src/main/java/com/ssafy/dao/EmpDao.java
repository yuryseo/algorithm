package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.Dept;
import com.ssafy.dto.Emp;

@Mapper
public interface EmpDao {
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
