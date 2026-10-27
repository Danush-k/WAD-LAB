package com.user.cr.Service;

import com.user.cr.Model.Student;
import com.user.cr.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Object addStudent(Student student) {
        String id=student.getStudentId();
        Optional<Student> existingStudent=studentRepository.findById(id);

        if(existingStudent.isPresent())
        {
            return("Student already in this id");
        }
        else
        {
            studentRepository.save(student);
            return ("New student added");
        }
    }

    public Object deleteStudent(String studentId) {
        Optional<Student> existingStudent=studentRepository.findById(studentId);

        if(existingStudent.isEmpty())
        {
            return("No student in this id"+studentId);
        }
        else
        {
            studentRepository.deleteById(studentId);
            return "Student deleted successfully: " + studentId;
        }

    }

    public Object updateStudentName(String studentId, String studentName) {
        Optional<Student> optStudent=studentRepository.findById(studentId);

        if(optStudent.isEmpty())
            return Map.of("msg","student Not found");

        Student student=optStudent.get();

        student.setStudentName(studentName);
        studentRepository.save(student);
        return Map.of("msg","Student Name changed");

    }
}
