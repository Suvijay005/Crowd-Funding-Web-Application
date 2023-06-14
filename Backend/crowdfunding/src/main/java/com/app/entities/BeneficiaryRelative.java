package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "beneficiary_relative")
@Getter
@Setter
@ToString
public class BeneficiaryRelative extends BaseEntity {
	@Column(name = "relative_name", length = 100)
	private String relativeName;

	@Column(length = 30)
	private String relation;

	private int age;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(length = 250)
	private String address;

	@Column(length = 30)
	private String city;

	@Column(name = "mobile_no", length = 20)
	private String beneficiaryMobile;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="campaign_id")
	private Campaign campaign;
	
}
