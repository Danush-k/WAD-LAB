package com.user.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "leaves")
public class Leave {
    @Id
    private String id;

    private String employeeId;
    private String employeeName;
    private String startDate;
    private String endDate;
    private Integer days;
    private String leaveReason;
    private String status; // APPROVED or REJECTED
    private Integer remainingLeave;
    private String appliedDate;
}
