package com.carbonsoft.eloadbilling.Models.Enums;

public enum RoleEnum {
	user("USER"), admin("ADMIN");

	private String name;

	RoleEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
