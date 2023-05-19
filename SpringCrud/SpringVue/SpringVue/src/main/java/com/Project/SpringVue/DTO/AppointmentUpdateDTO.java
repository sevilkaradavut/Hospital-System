package com.Project.SpringVue.DTO;

import com.Project.SpringVue.entity.Patient;

public class AppointmentUpdateDTO {

	private int appointmentid;
	private String appointmentdescription;
	private String appointmentdate;
	private Patient patient;

	public AppointmentUpdateDTO(int appointmentid, String appointmentdescription, String appointmentdate, Patient patient) {
		this.appointmentid = appointmentid;
		this.appointmentdescription = appointmentdescription;
		this.appointmentdate = appointmentdate;
		this.patient = patient;
	}

	public AppointmentUpdateDTO() {

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
		return "AppointmentUpdateDTO [appointmentid=" + appointmentid + ", appointmentdescription=" + appointmentdescription
				+ ", appointmentdate=" + appointmentdate + ", patient=" + patient + "]";
	}
	
}
