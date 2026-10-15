package com.user.coursereg2.Service;

import com.user.coursereg2.Model.Course;
import com.user.coursereg2.Model.Registration;
import com.user.coursereg2.Repository.CourseRepository;

import com.user.coursereg2.Repository.RegistrationRepository;
import com.user.coursereg2.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RegistrationService {
    RegistrationRepository registrationRepository;
    CourseRepository courseRepository;
    StudentRepository studentRepository;
    RegistrationService(RegistrationRepository r,CourseRepository c,StudentRepository  s)
    {
        this.registrationRepository=r;
        this.courseRepository=c;
        this.studentRepository=s;
    }
    public Object addRegistration(Registration registration) {
        String studentId=registration.getStudentId();
        String courseId= registration.getCourseId();
        String registrationId=registration.getRegistrationId();
        if(registrationRepository.existsById(registrationId))
            return Map.of("msg","Registration already exist");

        if(!courseRepository.existsById((courseId)))
            return Map.of("msg","Course doestnot exist");

        if(!studentRepository.existsById(studentId))
            return  Map.of("msg","Student doestnot exist");

        registrationRepository.save(registration);
        return  Map.of("msg","Registration Saved Successfully");

    }

    public Object getCoursesOfStudent(String studentId) {

        if(!studentRepository.existsById(studentId))
            return  Map.of("msg","Student doestnot exist");
        List<Registration> registrations=registrationRepository.findByStudentId(studentId);

        List<Course> courses=new ArrayList<>();

        for(Registration registration:registrations)
        {
            courses.add(courseRepository.findById(registration.getCourseId()).orElse(null));
        }
        return courses;


    }

    public Object deleteRegistration(String studentId, String courseId) {
        Optional<Registration> registration=registrationRepository.findByStudentIdAndCourseId(studentId,courseId);

        if(registration.isEmpty())
            return Map.of("msg","Registration Not Found");

        registrationRepository.delete(registration.get());
        return Map.of("msg","Registration Deleted Successfully");
    }


}
