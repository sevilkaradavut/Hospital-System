package com.Project.SpringVue.DTO;

import com.Project.SpringVue.entity.Doctor;

public class PatientUpdateDTO {

	private int patientid;
	private String patientname;
	private String patientaddress;
	private int phone;
	private Doctor doctor;
	
	public PatientUpdateDTO(int patientid, String patientname, String patientaddress, int phone, Doctor doctor) {
		this.patientid = patientid;
		this.patientname = patientname;
		this.patientaddress = patientaddress;
		this.phone = phone;
		this.doctor = doctor;
	}

	public PatientUpdateDTO() {

	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getPatientaddress() {
		return patientaddress;
	}

	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "PatientUpdateDTO [patientid=" + patientid + ", patientname=" + patientname + ", patientaddress="
				+ patientaddress + ", phone=" + phone + ", doctor=" + doctor + "]";
	}
	
}
