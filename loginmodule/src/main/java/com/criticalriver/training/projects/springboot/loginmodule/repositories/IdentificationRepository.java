package com.criticalriver.training.projects.springboot.loginmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.criticalriver.training.projects.springboot.loginmodule.beans.Identification;
@Repository
public interface IdentificationRepository extends JpaRepository<Identification, Integer>{
	Identification findByMobileNo(String mobileNo);
}
