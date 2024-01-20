package com.dollop.app.entity.payload.employee;

import java.sql.Timestamp;

import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.entity.status.AttendenceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class AttendanceResponse {
	
	private Long id;

    private String status;
    
    
    private UsersResponse userId;
    
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
    
    private Timestamp firstInTime;
    
    private String totalTime;
    
    
}
