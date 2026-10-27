package com.user.backend.Service;

import com.user.backend.Model.Employee;
import com.user.backend.Model.Leave;
import com.user.backend.Repository.EmployeeRepository;
import com.user.backend.Repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LeaveRepository leaveRepository;

    public Object getLeaveInfo(String leaveReason) {
        List<Leave> leaves=leaveRepository.findByLeaveReason(leaveReason);
        if(leaves.isEmpty())
        {
            return Map.of("msg","No such leave type here");
        }

        List<Employee> emp=new ArrayList<>();
        for(Leave leave:leaves)
        {
            Optional<Employee> optEmp=employeeRepository.findByEmployeeId(leave.getEmployeeId());
            if (optEmp.isPresent()) {
                emp.add(optEmp.get());
            }
        }
        return emp;

    }
}
