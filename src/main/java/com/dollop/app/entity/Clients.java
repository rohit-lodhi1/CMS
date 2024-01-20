package com.dollop.app.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;

	private String companyName;
	//colum text
	private String address;

	private String city;

	private String state;

	private String zip;

	private String country;

	private Date createdDate;
	//colum text
	private String website;
	
	private String ClientGroups;
	
	private String phone;
	
	private String currencySymbol;
	//colum mtext
	private String starredBy;
	//colum text
	private String vatNumber;
	
	private String gstNumber;
	
	private String status="Active";
	
	private String email;
	
	@OneToMany
	@JoinColumn(name="client_id")
	@JsonIgnoreProperties(value={"clientId"})
	private List<Projects> projects;
	
	
	private String currency;
	@ElementCollection
	@CollectionTable(name = "client_labels")
	@JoinColumn(name = "client_id")
	private List<String> labels;
	
	private Boolean deleted;
	
	
	@OneToOne
	private Users owner;
	
	private Boolean disableOnlinePayment;

}
