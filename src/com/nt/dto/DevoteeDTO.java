package com.nt.dto;

import java.time.LocalDate;

public class DevoteeDTO {

	private int id;
	private String name;
	private String husbandName;
	private long mobileNo;
	private String village;
	private String mandal;
	private String district;
	private LocalDate pregnancyDate;
	private LocalDate registeredDate;
	private LocalDate firstDate;
	private LocalDate visitDate;
	private short daysBetweenPdateAndFdate;
	private short daysBetweenPdateAndRdate;
	private short daysBetweenPdateAndVdate;
	private String visitStatus;
	private String status;
	private String otherDetails;
	private byte childNo;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
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
	
	public byte getChildNo() {
		return childNo;
	}

	public void setChildNo(byte childNo) {
		this.childNo = childNo;
	}


}
