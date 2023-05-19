package com.Project.SpringVue.DoctorRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Project.SpringVue.entity.Doctor;

@EnableJpaRepositories
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

}
