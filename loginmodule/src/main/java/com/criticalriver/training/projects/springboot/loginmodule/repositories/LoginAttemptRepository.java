package com.criticalriver.training.projects.springboot.loginmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.criticalriver.training.projects.springboot.loginmodule.beans.LoginAttempt;

@Repository
public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Integer>{
	LoginAttempt findTop1ByIdentityIdOrderByAttemptTimeDesc(Integer identityId);
}
