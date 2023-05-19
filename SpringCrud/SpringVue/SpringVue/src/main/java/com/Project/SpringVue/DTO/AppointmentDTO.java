package com.Project.SpringVue.DTO;

import com.Project.SpringVue.entity.Patient;


public class AppointmentDTO {

	private int appointmentid;
	private String appointmentdescription;
	private String appointmentdate;
	private Patient patient;

	public AppointmentDTO(int appointmentid, String appointmentdescription, String appointmentdate, Patient patient) {
		this.appointmentid = appointmentid;
		this.appointmentdescription = appointmentdescription;
		this.appointmentdate = appointmentdate;
		this.patient = patient;
	}

	public AppointmentDTO() {

	}
	
	public AppointmentDTO(int appointmentid, String appointmentdescription, String appointmentdate) {
		this.appointmentid = appointmentid;
		this.appointmentdescription = appointmentdescription;
		this.appointmentdate = appointmentdate;
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
		return "AppointmentDTO [appointmentid=" + appointmentid + ", appointmentdescription=" + appointmentdescription
				+ ", appointmentdate=" + appointmentdate + ", patient=" + patient + "]";
	}
	
}
