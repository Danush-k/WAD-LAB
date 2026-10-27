package com.user.backend.Controller;

import com.user.backend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/reason/{leaveReason}")
    public Object getLeaveInfo(@PathVariable String leaveReason)
    {
        return employeeService.getLeaveInfo(leaveReason);
    }
}
