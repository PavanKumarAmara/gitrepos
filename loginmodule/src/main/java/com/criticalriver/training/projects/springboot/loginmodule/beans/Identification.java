package com.criticalriver.training.projects.springboot.loginmodule.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="IDENTIFICATION")
public class Identification {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "mobile_no")
	private String mobileNo;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Identification( String mobileNo) {
		super();
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString() {
		return "Identification [id=" + id + ", mobileNo=" + mobileNo + "]";
	}

	public Identification() {}
}
