package com.user.backend.Repository;

import com.user.backend.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Optional<Employee> findByEmployeeId(String employeeId);

}
