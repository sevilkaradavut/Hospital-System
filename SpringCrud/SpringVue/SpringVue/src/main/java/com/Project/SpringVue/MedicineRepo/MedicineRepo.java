package com.Project.SpringVue.MedicineRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Project.SpringVue.entity.Medicine;

@EnableJpaRepositories
@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer>{

}
