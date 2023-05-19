package com.Project.SpringVue.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.SpringVue.DTO.MedicineDTO;
import com.Project.SpringVue.DTO.MedicineSaveDTO;
import com.Project.SpringVue.DTO.MedicineUpdateDTO;
import com.Project.SpringVue.MedicineRepo.MedicineRepo;
import com.Project.SpringVue.entity.Medicine;

@Service
public class MedicineServiceIMPL implements MedicineService{

	@Autowired
	private MedicineRepo medicineRepo;
	
	@Override
	public String addMedicine(MedicineSaveDTO medicineSaveDTO) {
	
		Medicine medicine = new Medicine(medicineSaveDTO.getMedicinedescription(),
				medicineSaveDTO.getExamination());
		medicineRepo.save(medicine);
		return medicine.getMedicinedescription();
	}

	@Override
	public List<MedicineDTO> getAllMedicine() {
	
		List<Medicine> getMedicines = medicineRepo.findAll();
		List<MedicineDTO> medicineDTOList = new ArrayList<>();

		for (Medicine m : getMedicines) {
			MedicineDTO medicineDTO = new MedicineDTO(m.getMedicineid(), m.getMedicinedescription());
			medicineDTOList.add(medicineDTO);
		}
		return medicineDTOList;
	}

	@Override
	public String updateMedicines(MedicineUpdateDTO medicineUpdateDTO) {
		
		if (medicineRepo.existsById(medicineUpdateDTO.getMedicineid())) {
			Medicine medicine = medicineRepo.getById(medicineUpdateDTO.getMedicineid());
			medicine.setMedicinedescription(medicineUpdateDTO.getMedicinedescription());
			medicine.setExamination(medicineUpdateDTO.getExamination());

			medicineRepo.save(medicine);
		} else {
			System.out.println("Medicine ID not Exist!");
		}
		return null;
	}

	@Override
	public boolean deleteMedicine(int id) {
		if (medicineRepo.existsById(id)) {
			medicineRepo.deleteById(id);
		} else {
			System.out.println("Medicine id not found!");
		}
		return true;
	}

}
