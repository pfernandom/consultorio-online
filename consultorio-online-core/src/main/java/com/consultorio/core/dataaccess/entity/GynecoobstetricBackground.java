package com.consultorio.core.dataaccess.entity;

import java.util.Date;
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
@Table(name = "gynecoobstetric_background")
public class GynecoobstetricBackground extends BaseEntity {
	@Id
	@Column(name = "gynecoobstetric_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "menarche")
	private Date menarche;
	
	@Column(name = "beggining_sexual_life")
	private Date begginingSexualLife;
	
	@Column(name = "pregnancies")
	private Integer pregnancies;
	
	@Column(name = "miscarriages")
	private Integer miscarriages;
	
	@Column(name = "c_sections")
	private Integer cSections;
	
	@Column(name = "pregnancy_complications", length = 500)
	private String pregnancyComplications;
	
	@OneToMany
	@JoinTable( name="contraceptive_background",
            joinColumns = @JoinColumn( name="gynecoobstetric_id"),
            inverseJoinColumns = @JoinColumn( name="contraceptive_id"))
	private List<Contraceptive> contraceptives;
	
	@Column(name = "latest_pap_test")
	private Date latestPapTest;
	
	@Column(name = "latest_pap_test_results", length = 500)
	private String latestPapTestResults;
	
	@Column(name = "latest_mammography")
	private Date latestMammography;
	
	@Column(name = "latest_mammography_results", length = 500)
	private String latestMammographyResults;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the menarche
	 */
	public Date getMenarche() {
		return menarche;
	}

	/**
	 * @param menarche the menarche to set
	 */
	public void setMenarche(Date menarche) {
		this.menarche = menarche;
	}

	/**
	 * @return the begginingSexualLife
	 */
	public Date getBegginingSexualLife() {
		return begginingSexualLife;
	}

	/**
	 * @param begginingSexualLife the begginingSexualLife to set
	 */
	public void setBegginingSexualLife(Date begginingSexualLife) {
		this.begginingSexualLife = begginingSexualLife;
	}

	/**
	 * @return the pregnancies
	 */
	public Integer getPregnancies() {
		return pregnancies;
	}

	/**
	 * @param pregnancies the pregnancies to set
	 */
	public void setPregnancies(Integer pregnancies) {
		this.pregnancies = pregnancies;
	}

	/**
	 * @return the miscarriages
	 */
	public Integer getMiscarriages() {
		return miscarriages;
	}

	/**
	 * @param miscarriages the miscarriages to set
	 */
	public void setMiscarriages(Integer miscarriages) {
		this.miscarriages = miscarriages;
	}

	/**
	 * @return the cSections
	 */
	public Integer getcSections() {
		return cSections;
	}

	/**
	 * @param cSections the cSections to set
	 */
	public void setcSections(Integer cSections) {
		this.cSections = cSections;
	}

	/**
	 * @return the pregnancyComplications
	 */
	public String getPregnancyComplications() {
		return pregnancyComplications;
	}

	/**
	 * @param pregnancyComplications the pregnancyComplications to set
	 */
	public void setPregnancyComplications(String pregnancyComplications) {
		this.pregnancyComplications = pregnancyComplications;
	}

	/**
	 * @return the contraceptives
	 */
	public List<Contraceptive> getContraceptives() {
		return contraceptives;
	}

	/**
	 * @param contraceptives the contraceptives to set
	 */
	public void setContraceptives(List<Contraceptive> contraceptives) {
		this.contraceptives = contraceptives;
	}

	/**
	 * @return the latestPapTest
	 */
	public Date getLatestPapTest() {
		return latestPapTest;
	}

	/**
	 * @param latestPapTest the latestPapTest to set
	 */
	public void setLatestPapTest(Date latestPapTest) {
		this.latestPapTest = latestPapTest;
	}

	/**
	 * @return the latestPapTestResults
	 */
	public String getLatestPapTestResults() {
		return latestPapTestResults;
	}

	/**
	 * @param latestPapTestResults the latestPapTestResults to set
	 */
	public void setLatestPapTestResults(String latestPapTestResults) {
		this.latestPapTestResults = latestPapTestResults;
	}

	/**
	 * @return the latestMammography
	 */
	public Date getLatestMammography() {
		return latestMammography;
	}

	/**
	 * @param latestMammography the latestMammography to set
	 */
	public void setLatestMammography(Date latestMammography) {
		this.latestMammography = latestMammography;
	}

	/**
	 * @return the latestMammographyResults
	 */
	public String getLatestMammographyResults() {
		return latestMammographyResults;
	}

	/**
	 * @param latestMammographyResults the latestMammographyResults to set
	 */
	public void setLatestMammographyResults(String latestMammographyResults) {
		this.latestMammographyResults = latestMammographyResults;
	}
	
	
}
