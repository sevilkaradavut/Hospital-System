package com.Project.SpringVue.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.SpringVue.DTO.PatientDTO;
import com.Project.SpringVue.DTO.PatientSaveDTO;
import com.Project.SpringVue.DTO.PatientUpdateDTO;
import com.Project.SpringVue.PatientRepo.PatientRepo;
import com.Project.SpringVue.entity.Patient;

@Service
public class PatientServiceIMPL implements PatientService {

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public String addPatient(PatientSaveDTO patientSaveDTO) {

		Patient patient = new Patient(patientSaveDTO.getPatientname(), patientSaveDTO.getPatientaddress(),
				patientSaveDTO.getPhone(), patientSaveDTO.getDoctor(), patientSaveDTO.getAppointments(), patientSaveDTO.getExaminations()

		);
		patientRepo.save(patient);
		return patient.getPatientname();
	}

	@Override
	public List<PatientDTO> getAllPatient() {

		List<Patient> getPatients = patientRepo.findAll();
		List<PatientDTO> patientDTOList = new ArrayList<>();

		for (Patient p : getPatients) {

			PatientDTO patientDTO = new PatientDTO(p.getPatientid(), p.getPatientname(), p.getPatientaddress(),
					p.getPhone()

			);
			patientDTOList.add(patientDTO);
		}
		return patientDTOList;
	}

	@Override
	public String updatePatients(PatientUpdateDTO patientUpdateDTO) {

		if (patientRepo.existsById(patientUpdateDTO.getPatientid())) {

			Patient patient = patientRepo.getById(patientUpdateDTO.getPatientid());

			patient.setPatientname(patientUpdateDTO.getPatientname());
			patient.setPatientaddress(patientUpdateDTO.getPatientaddress());
			patient.setPhone(patientUpdateDTO.getPhone());
			patient.setDoctor(patientUpdateDTO.getDoctor());

			patientRepo.save(patient);
		} else {
			System.out.println("Patient ID not Exist!");
		}
		return null;
	}

	@Override
	public boolean deletePatient(int id) {

		if (patientRepo.existsById(id)) {
			patientRepo.deleteById(id);
		} else {
			System.out.println("Patient id not found!");
		}
		return true;
	}

}
