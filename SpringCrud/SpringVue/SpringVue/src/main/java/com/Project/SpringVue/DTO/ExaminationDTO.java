package com.Project.SpringVue.DTO;

import java.util.List;

import com.Project.SpringVue.entity.Medicine;
import com.Project.SpringVue.entity.Patient;

public class ExaminationDTO {

	private int examinationid;
	private String examinationdescription;
	private Patient patient;
	private List<Medicine> medicines;
	
	public ExaminationDTO(int examinationid, String examinationdescription, Patient patient, List<Medicine> medicines) {
		this.examinationid = examinationid;
		this.examinationdescription = examinationdescription;
		this.patient = patient;
		this.medicines = medicines;
	}

	public ExaminationDTO() {

	}

	public ExaminationDTO(int examinationid, String examinationdescription) {
		this.examinationid = examinationid;
		this.examinationdescription = examinationdescription;
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

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "ExaminationDTO [examinationid=" + examinationid + ", examinationdescription=" + examinationdescription
				+ ", patient=" + patient + "]";
	}
	
}
