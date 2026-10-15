package com.user.coursereg2.Controller;

import com.user.coursereg2.Model.Student;
import com.user.coursereg2.Service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
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

    @PutMapping("/students/{studentId}/name")
    public Object updateStudentName(@PathVariable String studentId,
                                    @RequestBody Student student)
    {
        return studentService.updateStudentName(studentId,student.getStudentName());
    }

    @PostMapping("/students")
    public Object addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public Object deleteStudent(@PathVariable String studentId){
        return studentService.deleteStudent(studentId);
    }

}
