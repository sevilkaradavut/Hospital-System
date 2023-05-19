package com.Project.SpringVue.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.SpringVue.DTO.DoctorDTO;
import com.Project.SpringVue.DTO.DoctorSaveDTO;
import com.Project.SpringVue.DTO.DoctorUpdateDTO;
import com.Project.SpringVue.DoctorRepo.DoctorRepo;
import com.Project.SpringVue.entity.Doctor;

@Service
public class DoctorServiceIMPL implements DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;

	@Override
	public String addDoctor(DoctorSaveDTO doctorSaveDTO) {

		Doctor doctor = new Doctor(

				doctorSaveDTO.getDoctorname(), doctorSaveDTO.getDoctorbranch(), doctorSaveDTO.getPhone(), doctorSaveDTO.getPatients()

		);
		doctorRepo.save(doctor);
		return doctor.getDoctorname();
	}

	@Override
	public List<DoctorDTO> getAllDoctor() {
		List<Doctor> getDoctors = doctorRepo.findAll();
		List<DoctorDTO> doctorDTOList = new ArrayList<>();
		for (Doctor d : getDoctors) {

			DoctorDTO doctorDTO = new DoctorDTO(d.getDoctorid(), d.getDoctorname(), d.getDoctorbranch(), d.getPhone()

			);
			doctorDTOList.add(doctorDTO);
		}
		return doctorDTOList;
	}

	@Override
	public String updateDoctors(DoctorUpdateDTO doctorUpdateDTO) {

		if (doctorRepo.existsById(doctorUpdateDTO.getDoctorid())) {

			Doctor doctor = doctorRepo.getById(doctorUpdateDTO.getDoctorid());

			doctor.setDoctorname(doctorUpdateDTO.getDoctorname());
			doctor.setDoctorbranch(doctorUpdateDTO.getDoctorbranch());
			doctor.setPhone(doctorUpdateDTO.getPhone());

			doctorRepo.save(doctor);
		} else {
			System.out.println("Doctor ID not Exist!");
		}
		return null;
	}

	@Override
	public boolean deleteDoctor(int id) {

		if (doctorRepo.existsById(id)) {
			doctorRepo.deleteById(id);
		} else {
			System.out.println("Doctor id not found!");
		}
		return true;
	}

}
