package com.Project.SpringVue.DTO;

import java.util.List;

import com.Project.SpringVue.entity.Medicine;
import com.Project.SpringVue.entity.Patient;

public class ExaminationSaveDTO {

	private String examinationdescription;
	private Patient patient;
	private List<Medicine> medicines;

	public ExaminationSaveDTO(String examinationdescription, Patient patient, List<Medicine> medicines) {
		this.examinationdescription = examinationdescription;
		this.patient = patient;
		this.medicines = medicines;
	}

	public ExaminationSaveDTO() {

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
		return "ExaminationSaveDTO [examinationdescription=" + examinationdescription
				+ ", patient=" + patient + "]";
	}
	
}
