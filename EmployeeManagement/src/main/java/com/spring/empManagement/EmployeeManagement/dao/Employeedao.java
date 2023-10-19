package com.spring.empManagement.EmployeeManagement.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.empManagement.EmployeeManagement.model.Employee;
import com.spring.empManagement.EmployeeManagement.repository.CompRepo;
import com.spring.empManagement.EmployeeManagement.repository.EmpRepo;
@Repository
public class Employeedao {
	@Autowired
	private EmpRepo repo;
	@Autowired
	private CompRepo crepo;
	
	public List<Employee> findByEmpname(String empName)
	{
		return repo.findByEmpName(empName);
	}
	
	public List<Employee> findByJoiningDate(Date joiningDate){
		return repo.findByJoiningDate(joiningDate);
	}
	
	public List<Employee> findByYear(int year){
		return repo.getByYear(year);
	}
	
	public List<Employee> findByMonth(int month)
	{
		return repo.getByMonth(month);
	}
	
	
	
	
	
	
	

}
