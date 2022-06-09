package com.criticalriver.training.projects.springboot.loginmodule.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN_HISTORY")
public class LoginHistory {
	@Id
	@GeneratedValue
	@Column(name="history_id")
	private Integer historyId;
	@Column(name="identity_id")
	private Integer identityId;
	@Column(name="login_time")
	private Timestamp loggedInTime;
	@Column(name="logout_time")
	private Timestamp loggedOutTime;
	public Integer getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	public Integer getIdentityId() {
		return identityId;
	}
	public void setIdentityId(Integer identityId) {
		this.identityId = identityId;
	}
	public Timestamp getLoggedInTime() {
		return loggedInTime;
	}
	public void setLoggedInTime(Timestamp loggedInTime) {
		this.loggedInTime = loggedInTime;
	}
	public Timestamp getLoggedOutTime() {
		return loggedOutTime;
	}
	public void setLoggedOutTime(Timestamp loggedOutTime) {
		this.loggedOutTime = loggedOutTime;
	}
	@Override
	public String toString() {
		return "LoginHistory [historyId=" + historyId + ", identityId=" + identityId + ", loggedInTime=" + loggedInTime
				+ ", loggedOutTime=" + loggedOutTime + "]";
	}
	public LoginHistory( Integer identityId, Timestamp loggedInTime) {
		super();
		this.identityId = identityId;
		this.loggedInTime = loggedInTime;
	}
	public LoginHistory() {
		super();
	}
}
