package com.consultorio.core.dataaccess.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.untitled.dataaccess.entity.BaseEntity;

@Entity
@Table(name = "non_pathologic_background")
public class NonPathologicBackground extends BaseEntity{
	
	@Id
	@Column(name = "non_pathologic_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "housing", length = 50)
	private String housing;
	
	@Column(name = "zoonosis")
	private Boolean hasZoonosis;
	
	@Column(name = "zoonosis_observations", length = 500)
	private String zoonosis;
	
	@Column(name = "overcrowding")
	private Boolean isOvercrowded;
	
	@Column(name = "overcrowding_observations", length = 500)
	private String overcrowding;
	
	@Column(name = "balanced_feeding")
	private Boolean balancedFeeding;
	
	@Column(name = "unbalanced_feeding")
	private Boolean unbalancedFeeding;
	
	@Column(name = "mostly_carbs_feeding")
	private Boolean mostlyCarbsFeeding;
	
	@Column(name = "mostly_lipids_feeding")
	private Boolean mostlyLipidsFeeding;
	
	@Column(name = "mostly_proteins_feeding")
	private Boolean mostlyProteinsFeeding;
	
	@Column(name = "scarce_feeding")
	private Boolean scarceFeeding;
	
	@Column(name = "adequate_feeding")
	private Boolean adequateFeeding;
	
	@Column(name = "excessive_feeding")
	private Boolean excessiveFeeding;
	
	@Column(name = "feeding_observations", length = 500)
	private String feedingObservations;
	
	
	@Column(name = "bath_hygiene", length = 500)
	private String bathHygiene;
	
	@Column(name = "change_of_clothes_hygiene", length = 500)
	private String changeOfClothesHygiene;
	
	@Column(name = "oral_hygiene", length = 500)
	private String oralHygiene;
	
	@OneToMany
	@JoinTable( name="immunization_non_pathologic",
            joinColumns = @JoinColumn( name="non_pathologic_id"),
            inverseJoinColumns = @JoinColumn( name="immunization_id"))
	private List<Immunization> immunizations;
	
	
}
