package com.Project.SpringVue.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {

	@Id
	@Column(name = "id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicineid;
	
	@Column(name = "medicine_description", length = 70)
	private String medicinedescription;

	@ManyToOne(targetEntity = Examination.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "examination_id")
	private Examination examination;

	public Medicine(int medicineid, String medicinedescription, Examination examination) {
		this.medicineid = medicineid;
		this.medicinedescription = medicinedescription;
		this.examination = examination;
	}

	public Medicine() {

	}

	public Medicine(String medicinedescription, Examination examination) {
		this.medicinedescription = medicinedescription;
		this.examination = examination;
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
		return "Medicine [medicineid=" + medicineid + ", medicinedescription=" + medicinedescription + ", examination="
				+ examination + "]";
	}
	
	
	
}
