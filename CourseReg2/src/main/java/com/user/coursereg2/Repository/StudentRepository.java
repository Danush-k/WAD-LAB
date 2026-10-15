package com.user.coursereg2.Repository;

import com.user.coursereg2.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {
}
