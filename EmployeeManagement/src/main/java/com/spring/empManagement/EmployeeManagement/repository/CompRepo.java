package com.spring.empManagement.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.empManagement.EmployeeManagement.model.Company;
@Repository
public interface CompRepo extends JpaRepository<Company, Integer> {
	
	

}
