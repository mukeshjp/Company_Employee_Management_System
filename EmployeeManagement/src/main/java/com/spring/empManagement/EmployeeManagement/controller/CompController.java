package com.spring.empManagement.EmployeeManagement.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empManagement.EmployeeManagement.dao.Employeedao;
import com.spring.empManagement.EmployeeManagement.model.Company;
import com.spring.empManagement.EmployeeManagement.model.Employee;
import com.spring.empManagement.EmployeeManagement.repository.CompRepo;
import com.spring.empManagement.EmployeeManagement.repository.EmpRepo;
import com.spring.empManagement.EmployeeManagement.service.EmployeeService;

@RestController
public class CompController {

	@Autowired
	CompRepo compRepo;
	
	@Autowired
	EmpRepo empRepo;
	@Autowired
	Employeedao dao;
	@Autowired
    EmployeeService service;
	
	

	//private Integer empId;
	
	@PostMapping("/SaveRecords")
	public Company saveCompanyRecords(@RequestBody Company comp) {
		List<Employee> listOfEmployees =comp.getListOfEmployee();
		List<Employee> res=new ArrayList();
		if(listOfEmployees.isEmpty()) {
			comp=compRepo.save(comp);
		}else {
			comp=compRepo.save(comp);
			for(Employee emp:listOfEmployees) {
				emp.setCompany(comp);
				res.add(empRepo.save(emp));
			}
			
			comp.setListOfEmployee(listOfEmployees);
		}
		
		return comp;
	}
//	@GetMapping("/byDate")
//	public List<Employee> getEmployeesByDate(@RequestParam Date date)
//	{
//	   return empRepo.findByDateCreatedBetween(date)
//	}
	@GetMapping("/getAllEmployeeData")
	public List<Company> getAllEmployee()
    {
    List<Company> em = compRepo.findAll();
    	return em;
    }
	@GetMapping("/getempdata")
    public Employee getEmpData(@RequestParam int empId)
    {
    	Optional<Employee> em= empRepo.findById(empId);
    	if(em.isPresent()) {
    		return em.get();
    	}
    	
		return null;
    }
	@DeleteMapping("/deleterecord")
	public String deleteCompanyRecords(@RequestParam int empId)
	{
		Optional<Employee> companyRecord=empRepo.findById(empId);
		if(companyRecord.isPresent())
		{
			empRepo.deleteById(empId);
			return "Records has been successfully deleted";
		}
		return "Record not found";
		
	}
	
	
	@PutMapping("/updateEmployee")
	public Employee upadteEmployeeRecords(@RequestBody Employee emp)
	{
		empRepo.save(emp);
		return emp;
	}
	@GetMapping("/getByName")
	public List<Employee> findByName(@RequestParam String empName) {
		
		return dao.findByEmpname(empName);
	}
	
	@GetMapping("/GetRecordsByDate")
	public List<Employee> findByJoiningDate(@RequestParam Date joiningDate){
		return dao.findByJoiningDate(joiningDate);
	}
	
	@GetMapping("/GetByYear")
	public List<Employee> findByYear(@RequestParam int year){
		return dao.findByYear(year);
	}
	@GetMapping("/GetByMonth")
	public List<Employee> findByMonth(@RequestParam int month)
	{
		return dao.findByMonth(month);
	}
	
	
	
	
}
