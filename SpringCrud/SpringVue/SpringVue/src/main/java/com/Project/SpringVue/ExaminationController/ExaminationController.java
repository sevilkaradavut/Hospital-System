package com.Project.SpringVue.ExaminationController;

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

import com.Project.SpringVue.DTO.ExaminationDTO;
import com.Project.SpringVue.DTO.ExaminationSaveDTO;
import com.Project.SpringVue.DTO.ExaminationUpdateDTO;
import com.Project.SpringVue.Service.ExaminationService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/examination")
public class ExaminationController {

	@Autowired
	private ExaminationService examinationService;

	@PostMapping(path = "/save")
	public String saveExamination(@RequestBody ExaminationSaveDTO examinationSaveDTO) {

		String id = examinationService.addExamination(examinationSaveDTO);
		return id;
	}

	@GetMapping(path = "/getAllExamination")
	public List<ExaminationDTO> getAllExamination() {
		List<ExaminationDTO> allExaminations = examinationService.getAllExamination();
		return allExaminations;
	}

	@PutMapping(path = "/update")
	public String updateExamination(@RequestBody ExaminationUpdateDTO examinationUpdateDTO) {

		String id = examinationService.updateExaminations(examinationUpdateDTO);
		return id;
	}

	@DeleteMapping(path = "/deleteexamination/{id}")
	public String deleteExamination(@PathVariable(value = "id") int id) {

		examinationService.deleteExamination(id);
		return "Deleted";
	}
	
}
