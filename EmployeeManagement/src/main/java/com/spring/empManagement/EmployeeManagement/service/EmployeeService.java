package com.spring.empManagement.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.empManagement.EmployeeManagement.dao.Employeedao;
import com.spring.empManagement.EmployeeManagement.model.Employee;
import com.spring.empManagement.EmployeeManagement.responsestructure.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private Employeedao dao;
	
	ResponseStructure<Employee> structure=new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		Employee employee=(Employee) dao.findByEmpname(empName);
		if(employee!=null)
		{
			//.setMessege("data found succefully");
			structure.setMessege("data found successfully");
			//Structure.setStatus(HttpStatus.FOUND.value());
			//Structure.setStatus(id);
			structure.setStatus(HttpStatus.FOUND.value());
			//Structure.setData(employee);
			structure.setData(employee);
			return new ResponseEntity<>(structure,HttpStatus.FOUND);
		}
		return null;
	}
}


