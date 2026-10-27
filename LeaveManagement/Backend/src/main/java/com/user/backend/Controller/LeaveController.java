package com.user.backend.Controller;

import com.user.backend.Model.Leave;
import com.user.backend.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LeaveController {

    @Autowired
    LeaveService leaveService;

    @PostMapping("/apply")
    public Object applyLeave(@RequestBody Leave leave)
    {
        return leaveService.applyLeave(leave);
    }
}
