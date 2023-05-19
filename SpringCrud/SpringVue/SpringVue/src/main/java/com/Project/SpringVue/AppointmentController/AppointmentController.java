package com.Project.SpringVue.AppointmentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.SpringVue.DTO.AppointmentDTO;
import com.Project.SpringVue.DTO.AppointmentSaveDTO;
import com.Project.SpringVue.DTO.AppointmentUpdateDTO;
import com.Project.SpringVue.Service.AppointmentService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping(path = "/save")
	public String saveAppointment(@RequestBody AppointmentSaveDTO appointmentSaveDTO) {

		String id = appointmentService.addAppointment(appointmentSaveDTO);
		return id;
	}

	@GetMapping(path = "/getAllAppointment")
	public List<AppointmentDTO> getAllAppointment() {
		List<AppointmentDTO> allAppointments = appointmentService.getAllAppointment();
		return allAppointments;
	}

	@PutMapping(path = "/update")
	public String updateAppointment(@RequestBody AppointmentUpdateDTO appointmentUpdateDTO) {

		String id = appointmentService.updateAppointments(appointmentUpdateDTO);
		return id;
	}

	@DeleteMapping(path = "/deleteappointment/{id}")
	public String deleteAppointment(@PathVariable(value = "id") int id) {

		appointmentService.deleteAppointment(id);
		return "Deleted";
	}

}
