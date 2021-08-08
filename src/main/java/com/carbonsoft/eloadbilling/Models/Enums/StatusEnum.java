package com.carbonsoft.eloadbilling.Models.Enums;

public enum StatusEnum {
	active("ACTIVE"), inactive("INACTIVE");

	String name;

	StatusEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
