package com.user.cr.Controller;

import com.user.cr.Model.Student;
import com.user.cr.Service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {
    StudentService studentService;
    StudentController(StudentService s)
    {
        this.studentService=s;
    }

    @GetMapping("/students")
    public Object getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public Object addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public Object deleteStudent(@PathVariable String studentId)
    {
        return studentService.deleteStudent(studentId);
    }

    @PutMapping("/{studentId}/{studentName}")
    public Object updateStudentName(@PathVariable String studentId,
                                    @PathVariable String studentName)
    {
        return studentService.updateStudentName(studentId,studentName);
    }
}
