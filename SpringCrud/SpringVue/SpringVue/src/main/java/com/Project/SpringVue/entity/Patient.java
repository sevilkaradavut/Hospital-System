package com.Project.SpringVue.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@Column(name = "id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientid;
	
	@Column(name = "patient_name", length = 50)
	private String patientname;
	
	@Column(name = "address", length = 60)
	private String patientaddress;
	
	@Column(name = "phone", length = 12)
	private int phone;
	
	@ManyToOne(targetEntity = Doctor.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
	private List<Appointment> appointments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
	private List<Examination> examinations;
	
	public Patient(int patientid, String patientname, String patientaddress, int phone, Doctor doctor, List<Appointment> appointments, List<Examination> examinations) {

		this.patientid = patientid;
		this.patientname = patientname;
		this.patientaddress = patientaddress;
		this.phone = phone;
		this.doctor = doctor;
		this.appointments = appointments;
		this.examinations = examinations;
	}

	public Patient(int patientid) {
		
		this.patientid = patientid;
	}
	
	public Patient() {

	}

	public Patient(String patientname, String patientaddress, int phone, Doctor doctor, List<Appointment> appointments, List<Examination> examinations) {

		this.patientname = patientname;
		this.patientaddress = patientaddress;
		this.phone = phone;
		this.doctor = doctor;
		this.appointments = appointments;
		this.examinations = examinations;
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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	@Override
	public String toString() {
		return "Patient [patientid=" + patientid + ", patientname=" + patientname + ", patientaddress=" + patientaddress
				+ ", phone=" + phone + ", doctor=" + doctor + "]";
	}
	
	
	
}
