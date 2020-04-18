package model;

import java.time.LocalDate;

public class Crime {
	
	 private int complaint_no;
	 private int fir_no;
	 private int chargesheet_no;
	 private String act;
	 private String District;
	 private String Name;
	 private String Gender;
	 private int Age ;
	 private String Occupation;
	 private String Address;
	 private String Fname;
	 private String Nationality;
	 private String Descriprion;
	 private LocalDate Date;
	 private String Place;
	 private String PoliceName;
	 private String Status;
	 private String accused_name;
	 private String CrimeType;
	 
	public Crime() {
			
	} 
	
	public String getCrimeType() {
		return CrimeType;
	}

	public void setCrimeType(String crimeType) {
		CrimeType = crimeType;
	}
	public String getPoliceName() {
		return PoliceName;
	}
	public void setPoliceName(String policeName) {
		PoliceName = policeName;
	}
	public int getChargesheet_no() {
		return chargesheet_no;
	}

	public void setChargesheet_no(int chargesheet_no) {
		this.chargesheet_no = chargesheet_no;
	}

	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getDescriprion() {
		return Descriprion;
	}
	public void setDescriprion(String descriprion) {
		Descriprion = descriprion;
	}
	public int getComplaint_no() {
		return complaint_no;
	}
	public void setComplaint_no(int complaint_no1) {
		this.complaint_no = complaint_no1;
	}
	public int getFir_no() {
		return fir_no;
	}
	public void setFir_no(int fir_no) {
		this.fir_no = fir_no;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getOccupation() {
		return Occupation;
	}
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}

	public String getAccused_name() {
		return accused_name;
	}

	public void setAccused_name(String accused_name) {
		this.accused_name = accused_name;
	}
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
