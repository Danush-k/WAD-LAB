package com.user.coursereg2.Repository;

import com.user.coursereg2.Model.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorRepository extends MongoRepository<Instructor,String> {
}
