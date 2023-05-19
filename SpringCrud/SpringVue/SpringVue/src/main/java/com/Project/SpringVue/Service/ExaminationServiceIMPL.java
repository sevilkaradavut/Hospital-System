package com.Project.SpringVue.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.SpringVue.DTO.ExaminationDTO;
import com.Project.SpringVue.DTO.ExaminationSaveDTO;
import com.Project.SpringVue.DTO.ExaminationUpdateDTO;
import com.Project.SpringVue.ExaminationRepo.ExaminationRepo;
import com.Project.SpringVue.entity.Examination;

@Service
public class ExaminationServiceIMPL implements ExaminationService {

	@Autowired
	private ExaminationRepo examinationRepo;

	@Override
	public String addExamination(ExaminationSaveDTO examinationSaveDTO) {

		Examination examination = new Examination(examinationSaveDTO.getExaminationdescription(),
				examinationSaveDTO.getPatient(), examinationSaveDTO.getMedicines());
		examinationRepo.save(examination);
		return examination.getExaminationdescription();
	}

	@Override
	public List<ExaminationDTO> getAllExamination() {

		List<Examination> getExaminations = examinationRepo.findAll();
		List<ExaminationDTO> examinationDTOList = new ArrayList<>();

		for (Examination e : getExaminations) {
			ExaminationDTO examinationDTO = new ExaminationDTO(e.getExaminationid(), e.getExaminationdescription());
			examinationDTOList.add(examinationDTO);
		}
		return examinationDTOList;
	}

	@Override
	public String updateExaminations(ExaminationUpdateDTO examinationUpdateDTO) {

		if (examinationRepo.existsById(examinationUpdateDTO.getExaminationid())) {
			Examination examination = examinationRepo.getById(examinationUpdateDTO.getExaminationid());
			examination.setExaminationdescription(examinationUpdateDTO.getExaminationdescription());
			examination.setPatient(examinationUpdateDTO.getPatient());

			examinationRepo.save(examination);
		} else {
			System.out.println("Examination ID not Exist!");
		}
		return null;
	}

	@Override
	public boolean deleteExamination(int id) {
		if (examinationRepo.existsById(id)) {
			examinationRepo.deleteById(id);
		} else {
			System.out.println("Examination id not found!");
		}
		return true;
	}

}
