package com.criticalriver.training.projects.springboot.loginmodule.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.criticalriver.training.projects.springboot.loginmodule.beans.LoginHistory;
@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer>{
	List<LoginHistory> findByIdentityId(Integer identityId);
	LoginHistory findTop1ByIdentityIdOrderByLoggedInTimeDesc(Integer identityId);

}
