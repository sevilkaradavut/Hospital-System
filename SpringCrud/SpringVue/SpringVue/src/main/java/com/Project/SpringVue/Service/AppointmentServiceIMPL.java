package com.Project.SpringVue.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.SpringVue.AppointmentRepo.AppointmentRepo;
import com.Project.SpringVue.DTO.AppointmentDTO;
import com.Project.SpringVue.DTO.AppointmentSaveDTO;
import com.Project.SpringVue.DTO.AppointmentUpdateDTO;
import com.Project.SpringVue.entity.Appointment;

@Service
public class AppointmentServiceIMPL implements AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Override
	public String addAppointment(AppointmentSaveDTO appointmentSaveDTO) {

		Appointment appointment = new Appointment(appointmentSaveDTO.getAppointmentdescription(),
				appointmentSaveDTO.getAppointmentdate(), appointmentSaveDTO.getPatient());
		appointmentRepo.save(appointment);
		return appointment.getAppointmentdescription();
	}

	@Override
	public List<AppointmentDTO> getAllAppointment() {

		List<Appointment> getAppointments = appointmentRepo.findAll();
		List<AppointmentDTO> appointmentDTOList = new ArrayList<>();

		for (Appointment a : getAppointments) {

			AppointmentDTO appointmentDTO = new AppointmentDTO(a.getAppointmentid(), a.getAppointmentdescription(),
					a.getAppointmentdate());
			appointmentDTOList.add(appointmentDTO);
		}

		return appointmentDTOList;
	}

	@Override
	public String updateAppointments(AppointmentUpdateDTO appointmentUpdateDTO) {

		if (appointmentRepo.existsById(appointmentUpdateDTO.getAppointmentid())) {
			Appointment appointment = appointmentRepo.getById(appointmentUpdateDTO.getAppointmentid());

			appointment.setAppointmentdescription(appointmentUpdateDTO.getAppointmentdescription());
			appointment.setAppointmentdate(appointmentUpdateDTO.getAppointmentdate());
			appointment.setPatient(appointmentUpdateDTO.getPatient());

			appointmentRepo.save(appointment);
		} else {
			System.out.println("Appointment ID not Exist!");
		}
		return null;
	}

	@Override
	public boolean deleteAppointment(int id) {

		if (appointmentRepo.existsById(id)) {
			appointmentRepo.deleteById(id);
		} else {
			System.out.println("Appointment id not found!");
		}
		return true;
	}

}
