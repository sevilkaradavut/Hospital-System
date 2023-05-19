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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name = "id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentid;
	
	@Column(name = "appointment_description", length = 70)
	private String appointmentdescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "appointment_date")
	private String appointmentdate;

	@ManyToOne(targetEntity = Patient.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Appointment(int appointmentid, String appointmentdescription, String appointmentdate, Patient patient) {
		this.appointmentid = appointmentid;
		this.appointmentdescription = appointmentdescription;
		this.appointmentdate = appointmentdate;
		this.patient = patient;
	}

	public Appointment() {

	}
	
	public Appointment(String appointmentdescription, String appointmentdate, Patient patient) {
		this.appointmentdescription = appointmentdescription;
		this.appointmentdate = appointmentdate;
		this.patient = patient;
	}

	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}

	public String getAppointmentdescription() {
		return appointmentdescription;
	}

	public void setAppointmentdescription(String appointmentdescription) {
		this.appointmentdescription = appointmentdescription;
	}

	public String getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", appointmentdescription=" + appointmentdescription
				+ ", appointmentdate=" + appointmentdate + ", patient=" + patient + "]";
	}
	
	
	
	
}
