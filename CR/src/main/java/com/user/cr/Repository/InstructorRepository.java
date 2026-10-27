package com.user.cr.Repository;

import com.user.cr.Model.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorRepository extends MongoRepository<Instructor,String> {
}
