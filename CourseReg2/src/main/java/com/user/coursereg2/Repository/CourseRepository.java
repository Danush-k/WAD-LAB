package com.user.coursereg2.Repository;

import com.user.coursereg2.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course,String> {
}
