package com.Project.SpringVue.MedicineController;

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

import com.Project.SpringVue.DTO.MedicineDTO;
import com.Project.SpringVue.DTO.MedicineSaveDTO;
import com.Project.SpringVue.DTO.MedicineUpdateDTO;
import com.Project.SpringVue.Service.MedicineService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@PostMapping(path = "/save")
	public String saveMedicine(@RequestBody MedicineSaveDTO medicineSaveDTO) {

		String id = medicineService.addMedicine(medicineSaveDTO);
		return id;
	}

	@GetMapping(path = "/getAllMedicine")
	public List<MedicineDTO> getAllMedicine() {
		List<MedicineDTO> allMedicines = medicineService.getAllMedicine();
		return allMedicines;
	}

	@PutMapping(path = "/update")
	public String updateMedicine(@RequestBody MedicineUpdateDTO medicineUpdateDTO) {

		String id = medicineService.updateMedicines(medicineUpdateDTO);
		return id;
	}

	@DeleteMapping(path = "/deletemedicine/{id}")
	public String deleteMedicine(@PathVariable(value = "id") int id) {

		medicineService.deleteMedicine(id);
		return "Deleted";
	}
	
}
