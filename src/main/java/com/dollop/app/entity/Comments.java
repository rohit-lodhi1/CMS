package com.dollop.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Users createdBy;

	@ManyToOne
	@JoinColumn(name = "project_id_id")
	private Projects projectId;

	@ManyToOne
	private Tasks taskId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_comment_id")
	private List<ProjectFiles> fileId;

	private Integer customerFeedbackId;

	private String description;

	private LocalDateTime createdAt;
	private String type;

//	@PrePersist
//	public void prePersist() {
//		createdAt = new Timestamp(new Date().getTime()); // Set the current date before persisting
//	}

	private Boolean deleted;

}