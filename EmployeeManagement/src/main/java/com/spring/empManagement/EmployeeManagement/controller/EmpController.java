package com.spring.empManagement.EmployeeManagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empManagement.EmployeeManagement.model.Employee;
import com.spring.empManagement.EmployeeManagement.repository.EmpRepo;

@RestController
public class EmpController {
	@Autowired
	EmpRepo empRepo;
	
	/*@PostMapping
	public Employee saveEmp(Employee emp) {
		List<>
		return empRepo.save(emp);
	}*/
	
//	@GetMapping("/byDate")
//	public List<Employee> getEmployeesByDate(@DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam Date date)
//	{
//	   return empRepo.findByDateCreatedBetween(date);
//	}
//	@GetMapping("/byName")
//	public List<Employee> getEmployeesByName(@RequestParam String empname)
//	{
//		return empRepo.findByEmpname(empname);
//	}

}
