package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "donor")
@Getter
@Setter
@ToString(exclude = "campaigns")
public class Donor extends BaseEntity {
	@NotBlank(message = "Name cannot be blank!")
	@Column(length = 50)
	private String name;
	
	@NotBlank(message = "Email cannot be blank")
	@Column(length = 50)
	@Email
	private String email;
	
    @NotBlank(message="Mobile no cannot be blank")
	private String mobileNo;
    
	private double amount;
    
	@JsonIgnore
	@ManyToMany(mappedBy="donors")
	private Set<Campaign> campaigns=new HashSet<Campaign>();
}
