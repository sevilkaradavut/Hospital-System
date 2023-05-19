package com.Project.SpringVue.DTO;

import com.Project.SpringVue.entity.Examination;

public class MedicineDTO {


	private int medicineid;
	private String medicinedescription;
	private Examination examination;

	public MedicineDTO(int medicineid, String medicinedescription, Examination examination) {
		this.medicineid = medicineid;
		this.medicinedescription = medicinedescription;
		this.examination = examination;
	}

	public MedicineDTO() {

	}
	
	public MedicineDTO(int medicineid, String medicinedescription) {
		this.medicineid = medicineid;
		this.medicinedescription = medicinedescription;
	}
	
	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
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
		return "MedicineDTO [medicineid=" + medicineid + ", medicinedescription=" + medicinedescription + ", examination="
				+ examination + "]";
	}
	
	
}
