package com.Project.SpringVue.DTO;

import java.util.List;

import com.Project.SpringVue.entity.Appointment;
import com.Project.SpringVue.entity.Doctor;
import com.Project.SpringVue.entity.Examination;

public class PatientDTO {

	private int patientid;
	private String patientname;
	private String patientaddress;
	private int phone;
	private Doctor doctor;
	private List<Appointment> appointments;
	private List<Examination> examinations;
	
	public PatientDTO(int patientid, String patientname, String patientaddress, int phone, Doctor doctor, List<Appointment> appointments, List<Examination> examinations) {

		this.patientid = patientid;
		this.patientname = patientname;
		this.patientaddress = patientaddress;
		this.phone = phone;
		this.doctor = doctor;
		this.appointments = appointments;
		this.examinations = examinations;
	}

	public PatientDTO() {

	}

	public PatientDTO(int patientid, String patientname, String patientaddress, int phone) {
		this.patientid = patientid;
		this.patientname = patientname;
		this.patientaddress = patientaddress;
		this.phone = phone;

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
		return "PatientDTO [patientid=" + patientid + ", patientname=" + patientname + ", patientaddress="
				+ patientaddress + ", phone=" + phone + ", doctor=" + doctor + "]";
	}
	
	
	
}
