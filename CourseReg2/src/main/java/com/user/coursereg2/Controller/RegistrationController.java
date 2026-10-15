package com.user.coursereg2.Controller;

import com.user.coursereg2.Model.Registration;
import com.user.coursereg2.Service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    RegistrationService registrationService;
    RegistrationController(RegistrationService r)
    {
        this.registrationService=r;
    }
    @PostMapping("/register")
    public Object registerCourse(@RequestBody Registration registration)
    {
        return registrationService.addRegistration(registration);
    }

    //Get Registered Course for a student
    @GetMapping("/{studentId}/courses")
    public  Object getCoursesOfStudent(@PathVariable String studentId)
    {
        return registrationService.getCoursesOfStudent(studentId);
    }

    //DeleteRegistartion
    @DeleteMapping("/{studentId}/{courseId}")
    public  Object deleteRegistration(@PathVariable String studentId,
                                      @PathVariable String courseId)
    {
        return registrationService.deleteRegistration(studentId,courseId);
    }

}
