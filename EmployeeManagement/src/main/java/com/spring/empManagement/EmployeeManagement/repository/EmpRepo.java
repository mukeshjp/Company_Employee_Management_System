package com.spring.empManagement.EmployeeManagement.repository;

import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.empManagement.EmployeeManagement.model.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
	//List<Employee> findByDateCreatedBetween(Date joiningDate);
	
     public List<Employee> findByEmpName( String empName);
     public List<Employee> findByJoiningDate(Date joiningDate);
     
     /*@Query
     ("select e from Employee e where year(e.joiningDate) = ?1 and month(e.joiningDate) = ?2")
     List<Employee> getByYearAndMonth(int year, int month);*/
     
     @Query
     ("select e from Employee e where year(e.joiningDate) = ?1")
     List<Employee> getByYear(int year );
     @Query
     ("select e from Employee e where month(e.joiningDate) = ?1")
     List<Employee> getByMonth(int month);

}
