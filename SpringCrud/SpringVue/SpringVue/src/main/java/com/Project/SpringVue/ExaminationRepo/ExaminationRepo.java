package com.Project.SpringVue.ExaminationRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Project.SpringVue.entity.Examination;

@EnableJpaRepositories
@Repository
public interface ExaminationRepo extends JpaRepository<Examination, Integer>{

}
