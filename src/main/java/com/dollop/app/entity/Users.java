package com.dollop.app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	   @JoinColumn(name="u_id")
   @JsonManagedReference
   @EqualsAndHashCode.Exclude
	   private Set<UserRoles> userRoles;

	private Boolean isAdmin = false;

	private String email;

	private String password;

	private String originalName="profileImage";
	
	private String profileName="defaultUserImage.png";
	
	private String status;

	private Date messageCheckedAt;

	private Date notificationCheckedAt;

	private Boolean isPrime;

	private String jobTitle;

	private Boolean disableLogin = false;

	private String note;

	private String alternativeAddress;

	private String phone;
	// colum text
	private String address;

	private String alternativePhone;

	private Date dob;

	private String ssn;

	private String gender;
	// colum mtext
	private String stickyNote;
	// colum text
	private String skype;

	private Boolean enableWebNotification = false;

	private Boolean enableEmailNotification = false;

	private Date createdAt;

	private Boolean deleted = false;
	
	@ManyToOne
	@JoinColumn(name = "designationId")
	@JsonIgnoreProperties(value={"users","isDeleted","performanceIndicator"})
	private Designation designation;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value={"user"})
	private List<ExperienceInformations> experienceInformations = new ArrayList<>();


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value={"user"})
	private List<FamilyInformations> familyInformations = new ArrayList<>();



	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value={"user"})
	private List<EducationInformations> educationInformations = new ArrayList<>();


	@PrePersist
	public void created() {
		this.createdAt = new Date(System.currentTimeMillis());		
	}


	public Users(Integer id) {
		super();
		this.id = id;
	}
	
}
