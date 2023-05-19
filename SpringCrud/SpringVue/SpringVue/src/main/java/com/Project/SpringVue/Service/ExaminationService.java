package com.Project.SpringVue.Service;

import java.util.List;

import com.Project.SpringVue.DTO.ExaminationDTO;
import com.Project.SpringVue.DTO.ExaminationSaveDTO;
import com.Project.SpringVue.DTO.ExaminationUpdateDTO;

public interface ExaminationService {

	String addExamination(ExaminationSaveDTO examinationSaveDTO);

	List<ExaminationDTO> getAllExamination();

	String updateExaminations(ExaminationUpdateDTO examinationUpdateDTO);

    boolean deleteExamination(int id);
    
}
