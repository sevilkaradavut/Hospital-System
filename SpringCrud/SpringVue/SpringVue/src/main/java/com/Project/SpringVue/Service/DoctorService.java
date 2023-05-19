package com.Project.SpringVue.Service;

import java.util.List;

import com.Project.SpringVue.DTO.DoctorDTO;
import com.Project.SpringVue.DTO.DoctorSaveDTO;
import com.Project.SpringVue.DTO.DoctorUpdateDTO;

public interface DoctorService {

	String addDoctor(DoctorSaveDTO doctorSaveDTO);

	List<DoctorDTO> getAllDoctor();

	String updateDoctors(DoctorUpdateDTO doctorUpdateDTO);

    boolean deleteDoctor(int id);

}
