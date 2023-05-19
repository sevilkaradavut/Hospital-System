package com.Project.SpringVue.DTO;

public class DoctorUpdateDTO {

	private int doctorid;
	private String doctorname;
	private String doctorbranch;
	private int phone;
	
	public DoctorUpdateDTO(int doctorid, String doctorname, String doctorbranch, int phone) {
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.doctorbranch = doctorbranch;
		this.phone = phone;
	}

	public DoctorUpdateDTO() {

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

	@Override
	public String toString() {
		return "DoctorDTO [doctorid=" + doctorid + ", doctorname=" + doctorname + ", doctorbranch=" + doctorbranch
				+ ", phone=" + phone + "]";
	}
	
	
}
