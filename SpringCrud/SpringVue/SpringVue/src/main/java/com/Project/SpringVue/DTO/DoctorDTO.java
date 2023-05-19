package com.Project.SpringVue.DTO;

import java.util.List;

import com.Project.SpringVue.entity.Patient;

public class DoctorDTO {

	private int doctorid;
	private String doctorname;
	private String doctorbranch;
	private int phone;
	private List<Patient> patients;
	
	public DoctorDTO(int doctorid, String doctorname, String doctorbranch, int phone, List<Patient> patients) {

		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.doctorbranch = doctorbranch;
		this.phone = phone;
		this.patients = patients;
	}
	
	public DoctorDTO() {

	}

	public DoctorDTO(int doctorid, String doctorname, String doctorbranch, int phone) {

		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.doctorbranch = doctorbranch;
		this.phone = phone;
	}
	
	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getDoctorbranch() {
		return doctorbranch;
	}

	public void setDoctorbranch(String doctorbranch) {
		this.doctorbranch = doctorbranch;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	@Override
	public String toString() {
		return "DoctorDTO [doctorid=" + doctorid + ", doctorname=" + doctorname + ", doctorbranch=" + doctorbranch
				+ ", phone=" + phone + "]";
	}
	
	
	
}
