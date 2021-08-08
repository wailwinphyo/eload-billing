package com.carbonsoft.eloadbilling.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.carbonsoft.eloadbilling.Models.Enums.RoleEnum;
import com.carbonsoft.eloadbilling.Models.Enums.StatusEnum;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@Column(unique = true)
	private Integer phoneNumber;

	@Enumerated(value = EnumType.STRING)
	private RoleEnum role;

	@Enumerated(value = EnumType.STRING)
	private StatusEnum status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
