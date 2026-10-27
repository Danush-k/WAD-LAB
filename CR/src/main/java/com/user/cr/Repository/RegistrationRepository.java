package com.user.cr.Repository;

import com.user.cr.Model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationRepository extends MongoRepository<Registration,String> {

}
