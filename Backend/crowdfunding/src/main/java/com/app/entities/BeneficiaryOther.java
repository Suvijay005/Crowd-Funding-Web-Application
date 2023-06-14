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
@Table(name = "beneficiary_other")
@Getter
@Setter
@ToString
public class BeneficiaryOther extends BaseEntity {
	@Column(length = 100)
	private String name;

	private int age;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(length = 250)
	private String address;

	@Column(length = 30)
	private String city;

	@Column(name = "mobile_no", length = 20)
	private String mobileNo;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;
}
