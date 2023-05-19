package com.Project.SpringVue.DTO;

import com.Project.SpringVue.entity.Patient;

public class ExaminationUpdateDTO {

	private int examinationid;
	private String examinationdescription;
	private Patient patient;

	public ExaminationUpdateDTO(int examinationid, String examinationdescription, Patient patient) {
		this.examinationid = examinationid;
		this.examinationdescription = examinationdescription;
		this.patient = patient;
	}

	public ExaminationUpdateDTO() {

	}
	
	public int getExaminationid() {
		return examinationid;
	}

	public void setExaminationid(int examinationid) {
		this.examinationid = examinationid;
	}

	public String getExaminationdescription() {
		return examinationdescription;
	}

	public void setExaminationdescription(String examinationdescription) {
		this.examinationdescription = examinationdescription;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "ExaminationUpdateDTO [examinationid=" + examinationid + ", examinationdescription=" + examinationdescription
				+ ", patient=" + patient + "]";
	}
	
}
