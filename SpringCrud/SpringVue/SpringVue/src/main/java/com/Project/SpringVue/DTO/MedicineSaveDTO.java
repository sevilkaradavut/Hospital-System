package com.Project.SpringVue.DTO;

import com.Project.SpringVue.entity.Examination;

public class MedicineSaveDTO {

	private String medicinedescription;
	private Examination examination;

	public MedicineSaveDTO(String medicinedescription, Examination examination) {
		this.medicinedescription = medicinedescription;
		this.examination = examination;
	}

	public MedicineSaveDTO() {

	}

	public String getMedicinedescription() {
		return medicinedescription;
	}

	public void setMedicinedescription(String medicinedescription) {
		this.medicinedescription = medicinedescription;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	@Override
	public String toString() {
		return "MedicineSaveDTO [medicinedescription=" + medicinedescription + ", examination="
				+ examination + "]";
	}
	
}
