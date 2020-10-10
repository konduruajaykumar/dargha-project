package com.nt.bo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converts;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Devotees_SUCCESS")
@Converts({ @Convert(attributeName = "pregnancyDate", converter = LocalDateAttributeConverter.class),
		@Convert(attributeName = "firstDate", converter = LocalDateAttributeConverter.class),
		@Convert(attributeName = "visitDate", converter = LocalDateAttributeConverter.class),
		@Convert(attributeName = "registeredDate", converter = LocalDateAttributeConverter.class) })

public class DevoteeSuccessBO implements Serializable {
	@Id
	@Column(length = 10, nullable = false)
	@Type(type = "int")
	private int devoteeId;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(length = 30, nullable = false)
	@Type(type = "string")
	private String husbandName;

	@Column(length = 30, nullable = false)
	@Type(type = "string")
	private String village;

	@Column(length = 30, nullable = false)
	@Type(type = "string")
	private String mandal;

	@Column(length = 30, nullable = false)
	@Type(type = "string")
	private String district;

	@Column(length = 10, nullable = false)
	@Type(type = "long")
	private long mobileNo;

	@Column(nullable = false)
	// @Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate pregnancyDate;

	@Column(nullable = true)
	// @Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate registeredDate;

	@Column(nullable = false)
	// @Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate firstDate;

	@Column(nullable = false)
	// @Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate visitDate;

	@Column(length = 15, nullable = false)
	@Type(type = "string")
	private String visitStatus;

	@Column(length = 10, nullable = false)
	@Type(type = "string")
	private String status;

	@Column(length = 100, nullable = false)
	@Type(type = "string")
	private String otherDetails;

	@Column(length = 3, nullable = false)
	@Type(type = "short")
	private short daysBetweenPdateAndFdate;

	@Column(length = 3, nullable = true)
	@Type(type = "short")
	private short daysBetweenPdateAndRdate;

	@Column(length = 3, nullable = false)
	@Type(type = "short")
	private short daysBetweenPdateAndVdate;
	
	@Column(length = 2, nullable = false)
	@Type(type = "byte")
	private byte childNo;

	public int getDevoteeId() {
		return devoteeId;
	}

	public void setDevoteeId(int devoteeId) {
		this.devoteeId = devoteeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHusbandName() {
		return husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getPregnancyDate() {
		return pregnancyDate;
	}

	public void setPregnancyDate(LocalDate pregnancyDate) {
		this.pregnancyDate = pregnancyDate;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public LocalDate getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(LocalDate firstDate) {
		this.firstDate = firstDate;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public short getDaysBetweenPdateAndFdate() {
		return daysBetweenPdateAndFdate;
	}

	public void setDaysBetweenPdateAndFdate(short daysBetweenPdateAndFdate) {
		this.daysBetweenPdateAndFdate = daysBetweenPdateAndFdate;
	}

	public short getDaysBetweenPdateAndRdate() {
		return daysBetweenPdateAndRdate;
	}

	public void setDaysBetweenPdateAndRdate(short daysBetweenPdateAndRdate) {
		this.daysBetweenPdateAndRdate = daysBetweenPdateAndRdate;
	}

	public short getDaysBetweenPdateAndVdate() {
		return daysBetweenPdateAndVdate;
	}

	public void setDaysBetweenPdateAndVdate(short daysBetweenPdateAndVdate) {
		this.daysBetweenPdateAndVdate = daysBetweenPdateAndVdate;
	}
	
	public byte getChildNo() {
		return childNo;
	}

	public void setChildNo(byte childNo) {
		this.childNo = childNo;
	}

}