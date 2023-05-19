package com.Project.SpringVue.DTO;

import com.Project.SpringVue.entity.Patient;

public class AppointmentSaveDTO {

	private String appointmentdescription;
	private String appointmentdate;
	private Patient patient;

	public AppointmentSaveDTO(String appointmentdescription, String appointmentdate, Patient patient) {
		this.appointmentdescription = appointmentdescription;
		this.appointmentdate = appointmentdate;
		this.patient = patient;
	}

	public AppointmentSaveDTO() {

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
		return "AppointmentSaveDTO [appointmentdescription=" + appointmentdescription
				+ ", appointmentdate=" + appointmentdate + ", patient=" + patient + "]";
	}
}
