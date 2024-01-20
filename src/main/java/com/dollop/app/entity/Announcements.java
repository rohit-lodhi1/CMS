package com.dollop.app.entity;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Announcements {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	//colum text
	private String title;
	//colum mtext
	private String description;

    private Date startDate;
    
    private Date endDate;
    
    private Integer createdBy;
    
    private String shareWith;
    
    @CreatedDate
    private Timestamp createdAt;
  //colum mtext
    private String readBy;
    
    private Boolean deleted;
}
