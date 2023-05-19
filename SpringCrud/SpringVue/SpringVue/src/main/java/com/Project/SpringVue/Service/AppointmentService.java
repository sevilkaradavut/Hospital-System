package com.Project.SpringVue.Service;

import java.util.List;

import com.Project.SpringVue.DTO.AppointmentDTO;
import com.Project.SpringVue.DTO.AppointmentSaveDTO;
import com.Project.SpringVue.DTO.AppointmentUpdateDTO;


public interface AppointmentService {

	String addAppointment(AppointmentSaveDTO appointmentSaveDTO);

	List<AppointmentDTO> getAllAppointment();

	String updateAppointments(AppointmentUpdateDTO appointmentUpdateDTO);

    boolean deleteAppointment(int id);
}
