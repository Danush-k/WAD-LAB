package com.user.coursereg2.Controller;

import com.user.coursereg2.Model.Instructor;
import com.user.coursereg2.Service.InstructorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InstructorController {
    InstructorService instructorService;
    InstructorController(InstructorService i)
    {
        this.instructorService=i;
    }
    @PostMapping("/instructors")
    public Object addInstructor(@RequestBody Instructor instructor)
    {
        return  instructorService.addInstructor(instructor);
    }

}
