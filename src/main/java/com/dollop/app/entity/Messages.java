
package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Messages {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private Integer messageId;
	
	private Boolean deleted;
	//enum
	private String status;
	
	private String subject;
	// colum ,text
	private String message;
	// colum longtext
	private String files;
	// colum text
	private String deletedByUsers;
	
	private Date  createdAt;
	
	private Integer fromUserId;
	
	private Integer toUserId;
}
