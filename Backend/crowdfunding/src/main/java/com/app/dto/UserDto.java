package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    @JsonProperty(access=Access.READ_ONLY)//this implies user id will be serialized and sent to the client 
    private Long userId;                  //but it won't be read from the client and deserialized
    
    private Long id;
    @NotBlank(message="First name cannot be blank")
    private String firstName;
    
    @NotBlank(message="Last name cannot be blank")
    private String lastName;
    
    @NotBlank(message="Email cannot be blank")
    @Email(message="Invalid format")
    private String email;
    
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
	
	
	
}
