package com.Project.SpringVue.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@Column(name = "id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorid;
	
	@Column(name = "doctor_name", length = 50)
	private String doctorname;
	
	@Column(name = "doctor_branch", length = 60)
	private String doctorbranch;
	
	@Column(name = "phone", length = 12)
	private int phone;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "doctor")
	private List<Patient> patients;
	
	public Doctor(int doctorid, String doctorname, String doctorbranch, int phone, List<Patient> patients) {

		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.doctorbranch = doctorbranch;
		this.phone = phone;
		this.patients = patients;
	}

	public Doctor(int doctorid) {
		
		this.doctorid = doctorid;
	}
	
	public Doctor() {
		
	}
	
	public Doctor(String doctorname, String doctorbranch, int phone, List<Patient> patients) {

		this.doctorname = doctorname;
		this.doctorbranch = doctorbranch;
		this.phone = phone;
		this.patients = patients;
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
		return "Doctor [doctorid=" + doctorid + ", doctorname=" + doctorname + ", doctorbranch=" + doctorbranch
				+ ", phone=" + phone + "]";
	}
	
	

}
