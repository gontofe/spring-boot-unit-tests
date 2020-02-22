package com.michaelrichardhall.springboottest.persistence.repo;

import com.michaelrichardhall.springboottest.persistence.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByName(String name);

}
