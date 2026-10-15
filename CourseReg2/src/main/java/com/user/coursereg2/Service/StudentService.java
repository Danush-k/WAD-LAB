package com.user.coursereg2.Service;

import com.user.coursereg2.Model.Student;
import com.user.coursereg2.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    StudentService(StudentRepository s)
    {
        this.studentRepository=s;
    }
    public Object getAllStudents() {
        return studentRepository.findAll();
    }

    public Object updateStudentName(String studentId, String studentName) {
        Optional<Student> optStudent=studentRepository.findById(studentId);

        if(optStudent.isEmpty())
            return Map.of("msg","student Not found");

        Student student= optStudent.get();
        student.setStudentName(studentName);
        studentRepository.save(student);
        return Map.of("msg", "Student Name Updated Successfully");


    }

    public Object addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Object deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
        return Map.of("msg", "Student deleted successfully");
    }
}
