package com.criticalriver.training.projects.springboot.loginmodule.restcontrollers;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criticalriver.training.projects.springboot.loginmodule.beans.Identification;
import com.criticalriver.training.projects.springboot.loginmodule.beans.LoginAttempt;
import com.criticalriver.training.projects.springboot.loginmodule.beans.LoginHistory;
import com.criticalriver.training.projects.springboot.loginmodule.repositories.IdentificationRepository;
import com.criticalriver.training.projects.springboot.loginmodule.repositories.LoginAttemptRepository;
import com.criticalriver.training.projects.springboot.loginmodule.repositories.LoginHistoryRepository;
import com.criticalriver.training.projects.springboot.loginmodule.utils.Utility;

@RestController
public class LoginRestController {
	@Autowired
	public IdentificationRepository identificationRepository;
	@Autowired
	public LoginAttemptRepository loginAttemptRepository;
	@Autowired
	public LoginHistoryRepository loginHistoryRepository;
	
	@RequestMapping("/generateOTP/{mobileno}")
	String generateOTP(@PathVariable String mobileno) {
		String generatedOtp = String.valueOf(Utility.getRandomNumber(1000, 9999));
		Identification identity = saveOrRetrieveIdentity(mobileno);
		System.out.println(identity.toString());
		saveGeneratedOtp(identity.getId(),generatedOtp,new Timestamp(System.currentTimeMillis()));
		return generatedOtp;
	}
	
	@RequestMapping("submitotp/{identityid}/{otp}")
	Boolean validteOtp(@PathVariable String identityid,@PathVariable String otp) {
		LoginAttempt loginAttempt = loginAttemptRepository.findTop1ByIdentityIdOrderByAttemptTimeDesc(Integer.parseInt(identityid));
		Boolean isValidAttempt = loginAttempt.getGeneratedOtp().equals(otp);
		loginAttempt.setIsValid(isValidAttempt?1:0);
		loginAttempt.setEnteredOtp(otp);
		try {
			loginAttemptRepository.save(loginAttempt);
			if(isValidAttempt) {
				LoginHistory lh = new LoginHistory(Integer.parseInt(identityid),new Timestamp(System.currentTimeMillis()));
				loginHistoryRepository.save(lh);
				lh=null;
			}
		}catch(Exception e) {return false;}
		return isValidAttempt;
	}
	
	
	private void saveGeneratedOtp(Integer id, String generatedOtp, Timestamp date) {
		LoginAttempt loginAttempt = loginAttemptRepository.save(new LoginAttempt(id,generatedOtp,null,date,0));
	}
	
	
	
	private Identification saveOrRetrieveIdentity(String mobileno) {
		Identification identity = null;
		Optional<Identification> data= checkIfIdentityExists(mobileno);
		if(!data.isPresent()) {
			identity = new Identification();
			identity.setMobileNo(mobileno);
			identity = identificationRepository.save(identity);
		}else {
			identity = (Identification)data.get();
		}
		return identity;
	}
	private Optional<Identification> checkIfIdentityExists(String mobileNo) {
		Optional<Identification> identity =  Optional.ofNullable(identificationRepository.findByMobileNo(mobileNo));
		return identity;
	}
}
