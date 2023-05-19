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
@Table(name = "examination")
public class Examination {

	@Id
	@Column(name = "id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examinationid;
	
	@Column(name = "examination_description", length = 70)
	private String examinationdescription;

	@ManyToOne(targetEntity = Patient.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "examination")
	private List<Medicine> medicines;
	
	public Examination(int examinationid, String examinationdescription, Patient patient, List<Medicine> medicines) {
		this.examinationid = examinationid;
		this.examinationdescription = examinationdescription;
		this.patient = patient;
		this.medicines = medicines;
	}

	public Examination() {

	}
	

	public Examination(int examinationid) {
		
		this.examinationid = examinationid;
	}

	public Examination(String examinationdescription, Patient patient, List<Medicine> medicines) {
		this.examinationdescription = examinationdescription;
		this.patient = patient;
		this.medicines = medicines;
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
		return "Examination [examinationid=" + examinationid + ", examinationdescription=" + examinationdescription
				+ ", patient=" + patient + "]";
	}
	
	
	
}
