package com.Project.SpringVue.DTO;

import java.util.List;

import com.Project.SpringVue.entity.Patient;

public class DoctorSaveDTO {

	private String doctorname;
	private String doctorbranch;
	private int phone;
	private List<Patient> patients;
	
	public DoctorSaveDTO(String doctorname, String doctorbranch, int phone, List<Patient> patients) {

		this.doctorname = doctorname;
		this.doctorbranch = doctorbranch;
		this.phone = phone;
		this.patients = patients;
	}

	public DoctorSaveDTO() {

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
		return "DoctorSaveDTO [doctorname=" + doctorname + ", doctorbranch=" + doctorbranch
				+ ", phone=" + phone + "]";
	}
	
}
