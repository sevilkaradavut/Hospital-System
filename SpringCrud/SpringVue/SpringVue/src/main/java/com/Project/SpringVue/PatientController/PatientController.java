package com.Project.SpringVue.PatientController;

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

import com.Project.SpringVue.DTO.PatientDTO;
import com.Project.SpringVue.DTO.PatientSaveDTO;
import com.Project.SpringVue.DTO.PatientUpdateDTO;
import com.Project.SpringVue.Service.PatientService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping(path = "/save")
	public String savePatient(@RequestBody PatientSaveDTO patientSaveDTO) {

		String id = patientService.addPatient(patientSaveDTO);
		return id;
	}

	@GetMapping(path = "/getAllPatient")
	public List<PatientDTO> getAllPatient() {
		List<PatientDTO> allPatients = patientService.getAllPatient();
		return allPatients;
	}

	@PutMapping(path = "/update")
	public String updatePatient(@RequestBody PatientUpdateDTO patientUpdateDTO) {

		String id = patientService.updatePatients(patientUpdateDTO);
		return id;
	}

	@DeleteMapping(path = "/deletepatient/{id}")
	public String deletePatient(@PathVariable(value = "id") int id) {

		patientService.deletePatient(id);
		return "Deleted";
	}
}
