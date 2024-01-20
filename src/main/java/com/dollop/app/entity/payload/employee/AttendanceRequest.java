package com.dollop.app.entity.payload.employee;

import java.sql.Timestamp;

import com.dollop.app.entity.TrainingType;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.status.AttendenceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRequest {
	private Long id;

    private String status;
    
    
    private Users userId;
    
    private String attendenceStatus=AttendenceStatus.Incompelete.toString();
    
    private Timestamp inTime;

    private Timestamp outTime;
    
    private Integer checkedBy;
  //colum text
    private String note;
    
    private Timestamp checkedAt;
  //colum text
    private String rejectReason;
    
    private Boolean deleted;
}
