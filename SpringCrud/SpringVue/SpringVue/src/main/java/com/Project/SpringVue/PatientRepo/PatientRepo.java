package com.Project.SpringVue.PatientRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Project.SpringVue.entity.Patient;

@EnableJpaRepositories
@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
