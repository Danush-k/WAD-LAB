package com.user.backend.Repository;

import com.user.backend.Model.Leave;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LeaveRepository extends MongoRepository<Leave,String> {
    List<Leave> findByLeaveReason(String leaveReason);
}
