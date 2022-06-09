package com.criticalriver.training.projects.springboot.loginmodule.beans;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN_ATTEMPT")
public class LoginAttempt {
	@Id
	@GeneratedValue
	@Column(name="attempt_id")
	private Integer attmeptId;
	@Column(name="identity_id")
	private Integer identityId;
	@Column(name="generated_otp")
	private String generatedOtp;
	@Column(name="user_entered_otp")
	private String enteredOtp;
	@Column(name="attempt_time")
	private Timestamp attemptTime;
	@Column(name="is_valid")
	private int isValid;
	public Integer getAttmeptId() {
		return attmeptId;
	}
	public void setAttmeptId(Integer attmeptId) {
		this.attmeptId = attmeptId;
	}
	public Integer getidentityId() {
		return identityId;
	}
	public void setidentityId(Integer identityId) {
		this.identityId = identityId;
	}
	public String getGeneratedOtp() {
		return generatedOtp;
	}
	public void setGeneratedOtp(String generatedOtp) {
		this.generatedOtp = generatedOtp;
	}
	public String getEnteredOtp() {
		return enteredOtp;
	}
	public void setEnteredOtp(String enteredOtp) {
		this.enteredOtp = enteredOtp;
	}
	public Timestamp getDate() {
		return attemptTime;
	}
	public void setDate(Timestamp attemptTime) {
		this.attemptTime = attemptTime;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public LoginAttempt( Integer identityId, String generatedOtp, String enteredOtp, Timestamp attemptTime,
			int isValid) {
		super();
		this.identityId = identityId;
		this.generatedOtp = generatedOtp;
		this.enteredOtp = enteredOtp;
		this.attemptTime = attemptTime;
		this.isValid = isValid;
	}
	
	public LoginAttempt() {}
	
	@Override
	public String toString() {
		return "LoginAttempt [attmeptId=" + attmeptId + ", identiyId=" + identityId + ", generatedOtp=" + generatedOtp
				+ ", enteredOtp=" + enteredOtp + ", date=" + attemptTime + ", isValid=" + isValid + "]";
	}
	

}
