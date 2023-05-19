package com.Project.SpringVue.Service;

import java.util.List;

import com.Project.SpringVue.DTO.PatientDTO;
import com.Project.SpringVue.DTO.PatientSaveDTO;
import com.Project.SpringVue.DTO.PatientUpdateDTO;


public interface PatientService {

	String addPatient(PatientSaveDTO patientSaveDTO);

	List<PatientDTO> getAllPatient();

	String updatePatients(PatientUpdateDTO patientUpdateDTO);

    boolean deletePatient(int id);
}
