package com.user.backend.Service;

import com.user.backend.Model.Employee;
import com.user.backend.Model.Leave;
import com.user.backend.Repository.EmployeeRepository;
import com.user.backend.Repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class LeaveService {
    @Autowired
    LeaveRepository leaveRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Object applyLeave(Leave leave) {

        Optional<Employee> optEmp=employeeRepository.findByEmployeeId(leave.getEmployeeId());

        if(optEmp.isEmpty())
        {
            return ("Employee of such id Doesnot exist");
        }

        Employee employee=optEmp.get();

        if(leave.getDays() > employee.getAvailableLeave())
        {
            leave.setStatus("Rejected");
            leaveRepository.save(leave);

            return Map.of("message", "Insufficient leave");
        }
        else
        {
            employee.setAvailableLeave(
                    employee.getAvailableLeave()- leave.getDays());
            employeeRepository.save(employee);

            leave.setEmployeeName(employee.getEmployeeName());
            leave.setStatus("Approved");
            leave.setRemainingLeave(employee.getAvailableLeave());
            leaveRepository.save(leave);


            return Map.of("message", "Leave approved");
        }
    }
}
