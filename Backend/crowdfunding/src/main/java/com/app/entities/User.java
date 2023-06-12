package com.app.entities;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="password")
public class User extends BaseEntity {
	@NotBlank(message="First name cannot be blank")
	@Length(min=3, max=25, message="Length should be between 3-25 characters")
    @Column(name="first_name", length=25)
	private String firstName;
	
    @NotBlank(message="Last name cannot be blank")
	@Column(name="last_name", length=25)
	private String lastName;
    
    @Column(name="email", length=50, unique=true)
    @Email(message="Invalid format")
    private String email;
    
    @Column(length=50)
    @JsonProperty( access = Access.WRITE_ONLY)
    private String password;
    
    @Column(name="mobile_no", length=20)
    private String mobileNo;
    
    @Column(length=250)
    private String address;
    
    @Column(length=30)
    private String city;
    
    @Column(length=30)
    private String state;
    
    @Column(length=30)
    private String country;
    
    @Column(length=15)
    private String pincode;
    
    @Enumerated(EnumType.STRING)
    @Column(length=10)
    @NotNull(message="Role must be selected")
    private Role role;
    
    
	
}
