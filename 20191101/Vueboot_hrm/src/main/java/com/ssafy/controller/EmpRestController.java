package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.Dept;
import com.ssafy.dto.Emp;
import com.ssafy.service.EmpService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
public class EmpRestController {
	@Autowired
	private EmpService service;

	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> handle(Exception e) {
		return handleFail(e.getMessage(), HttpStatus.OK);
	}

	@ApiOperation("새로운 사원 정보 등록")
	@PostMapping("/api/addEmployee")
	public ResponseEntity<Map<String, Object>> addEmployee(@RequestBody Emp emp) {
		
		service.addEmployee(emp);
		return handleSuccess("사원 등록 완료");
	}

	@ApiOperation("해당 사원의 정보를 삭제한다.")
	@DeleteMapping("/api/deleteEmployee/{employeeid}")
	public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int employeeid) {
		service.deleteEmployee(employeeid);
		return handleSuccess("삭제 완료");
	}

	@ApiOperation("사원의 정보를 수정한다.")
	@PutMapping("/api/updateEmployee")
	public ResponseEntity<Map<String, Object>> updateEmployee(@RequestBody Emp emp) {
		service.updateEmployee(emp);
		return handleSuccess("사원 정보 수정 완료 ");
	}

	@ApiOperation("전체 사원 목록을 조회하는 기능")
	@GetMapping("/api/findAllEmployees")
	public ResponseEntity<Map<String, Object>> findAllEmployees() {
		List<Emp> list = service.findAllEmployees();
		return handleSuccess(list);
	}

	@ApiOperation("전체 부서 목록을 조회하는 기능")
	@GetMapping("/api/findAllDepartment")
	public ResponseEntity<Map<String, Object>> findAllDepartment() {
		List<String> list = service.findAllDepartment();
		return handleSuccess(list);
	}

	@ApiOperation("직책 목록을 조회하는 기능")
	@GetMapping("/api/findAllTitles")
	public ResponseEntity<Map<String, Object>> findAllTitles() {
		List<String> list = service.findAllTitles();
		return handleSuccess(list);
	}

	@ApiOperation("사원 아이디로 사원 정보 찾기")
	@GetMapping("api/findEmployeeById/{id}")
	public ResponseEntity<Map<String, Object>> findEmployeeById(@PathVariable int id) {
		return handleSuccess(service.findEmployeeById(id));
	}

	@ApiOperation("이름 일부분에 해당하는 사원의 정보를 반환")
	@GetMapping("api/findLikeEmployee/{name}")
	public ResponseEntity<Map<String, Object>> findLikeEmployee(@PathVariable String name) {
		return handleSuccess(service.findLikeEmployee(name));
	}

	@ApiOperation("모든 사원의 수를 반환 한다")
	@GetMapping("api/getEmployeesTotal")
	public ResponseEntity<Map<String, Object>> getEmployeesTotal() {
		return handleSuccess(service.getEmployeesTotal());
	}
	
	@ApiOperation("부서번호로 부서의 정보와 소속된 직원들의 정보를 함께 찾아온다")
	@GetMapping("api/findDepartmentEmployees/{id}")
	public ResponseEntity<Map<String, Object>> findDepartmentEmployees(@PathVariable int id) throws Exception {
		Dept dept = service.findDepartmentEmployees(id);
		/*
		 * if(dept==null || dept.getDept_id()) {
		 * 
		 * }
		 */
		return handleSuccess(service.findDepartmentEmployees(id));
	}
	
	
	public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "fail");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, state);
	}

	public ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "ok");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
}
