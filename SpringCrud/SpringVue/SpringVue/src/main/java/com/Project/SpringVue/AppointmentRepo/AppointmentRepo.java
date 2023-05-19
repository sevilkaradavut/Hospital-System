package com.Project.SpringVue.AppointmentRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Project.SpringVue.entity.Appointment;

@EnableJpaRepositories
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{

}
