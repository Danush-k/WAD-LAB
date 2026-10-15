package com.user.coursereg2.Repository;

import com.user.coursereg2.Model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends MongoRepository<Registration,String> {
    List<Registration> findByStudentId(String studentId);
    Optional<Registration> findByStudentIdAndCourseId(
            String studentId,
            String courseId
    );
}
