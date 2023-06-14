package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "beneficiary_self")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BeneficiarySelf extends BaseEntity {
	@Column(length = 50)
	private String name;
	
	private int age;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;

}
