package com.user.coursereg2.Service;

import com.user.coursereg2.Model.Instructor;
import com.user.coursereg2.Repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InstructorService {
    InstructorRepository instructorRepository;
    InstructorService(InstructorRepository i)
    {
        this.instructorRepository=i;
    }
    public Object addInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
        return Map.of("msg","Instructor Added Successfully");
    }
}
