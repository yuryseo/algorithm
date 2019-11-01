package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssafy.dao.EmpDao;
import com.ssafy.dto.Dept;
import com.ssafy.dto.Emp;
import com.ssafy.dto.EmpException;

@Component
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao dao;

	public void addEmployee(Emp emp) {
		try {
			dao.addEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("저장 중 오류가 발생했습니다.");
		}
		
	}

	@Override
	public void updateEmployee(Emp emp) {
		try {
			dao.updateEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("업데이트 중 오류가 발생했습니다.");
		}
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		try {
			dao.deleteEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("삭제 중 오류가 발생했습니다.");
		}
		

	}
	
	@Override
	public Emp findEmployeeById(int id) {
		
		try {
			return dao.findEmployeeById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("아이디로 검색 중 오류 발생");
		}
		
	}

	@Override
	public List<Emp>  findLikeEmployee(String name) {
		try {
			return dao.findLikeEmployee(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("이름으로 검색 중 오류 발생");
		}
	}

	@Override
	public List<Emp> findAllEmployees() {
		try {
			return dao.findAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("모든 사원 정보 조회 중 오류 발생");
		}
	}

	@Override
	public List<String> findAllTitles() {
		try {
			return dao.findAllTitles();
					
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("직책 목록 조회 중 오류 발생");
		}
	}

	@Override
	public int getEmployeesTotal() {
		try {
			return dao.getEmployeesTotal();
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("사원 수 조회 중 오류 발생");
		}
	}

	@Override
	public List<String> findAllDepartment() {
		try {
			return dao.findAllDepartment();
					
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("모든 부서 조회 중 오류 발생");
		}
	}

	@Override
	public Dept findDepartmentEmployees(int id) throws Exception {
		
		return dao.findDepartmentEmployees(id);
	}


}
