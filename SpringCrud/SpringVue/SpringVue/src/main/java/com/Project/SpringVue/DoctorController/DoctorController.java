package com.Project.SpringVue.DoctorController;

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

import com.Project.SpringVue.DTO.DoctorDTO;
import com.Project.SpringVue.DTO.DoctorSaveDTO;
import com.Project.SpringVue.DTO.DoctorUpdateDTO;
import com.Project.SpringVue.Service.DoctorService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping(path = "/save")
	public String saveDoctor(@RequestBody DoctorSaveDTO doctorSaveDTO) {

		String id = doctorService.addDoctor(doctorSaveDTO);
		return id;
	}

	@GetMapping(path = "/getAllDoctor")
	public List<DoctorDTO> getAllDoctor() {
		List<DoctorDTO> allDoctors = doctorService.getAllDoctor();
		return allDoctors;
	}


	@PutMapping(path = "/update")
	public String updateDoctor(@RequestBody DoctorUpdateDTO doctorUpdateDTO) {

		String id = doctorService.updateDoctors(doctorUpdateDTO);
		return id;
	}

	@DeleteMapping(path = "/deletedoctor/{id}")
	public String deleteDoctor(@PathVariable(value = "id") int id) {

		boolean deletedoctor = doctorService.deleteDoctor(id);
		return "Deleted";
	}
}
