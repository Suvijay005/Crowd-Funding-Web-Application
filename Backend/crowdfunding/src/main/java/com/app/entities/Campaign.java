package com.app.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Campaign extends BaseEntity {
	private double amount;
	@Column(name = "current_amount")
	private double currentAmount;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(length = 300)
	private String title;
	@Value("${some.key:false}")
	private boolean active;
	@Column(name = "hospital_name", length = 100)
	private String hospitalName;
	@Column(name = "hospital_city", length = 40)
	private String hospitalCity;
	@Column(length = 100)
	private String ailment;
	@Column(name = "image_path")
	private String imagePath;
	@Column(length = 1500)
	private String Description;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User usr;

	@OneToOne(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
	private BeneficiarySelf beneficiarySelf;

	@OneToOne(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
	private BeneficiaryRelative beneficiaryRelative;

	@OneToOne(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
	private BeneficiaryOther beneficiaryOther;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "campaign_donor", joinColumns = @JoinColumn(name = "campaign_id"), inverseJoinColumns = @JoinColumn(name = "donor_id"))
	private Set<Donor> donors = new HashSet<Donor>();

	@Column(name = "no_of_donors")
	private int noOfDonors = donors.size();

}
