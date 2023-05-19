package com.Project.SpringVue.Service;

import java.util.List;

import com.Project.SpringVue.DTO.MedicineDTO;
import com.Project.SpringVue.DTO.MedicineSaveDTO;
import com.Project.SpringVue.DTO.MedicineUpdateDTO;

public interface MedicineService {

	String addMedicine(MedicineSaveDTO medicineSaveDTO);

	List<MedicineDTO> getAllMedicine();

	String updateMedicines(MedicineUpdateDTO medicineUpdateDTO);

    boolean deleteMedicine(int id);
}
