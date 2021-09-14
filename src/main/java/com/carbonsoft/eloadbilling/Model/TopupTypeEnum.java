package com.carbonsoft.eloadbilling.Model;

public enum TopupTypeEnum {

	eload("E-LOAD"), transfer("TRANSFER");

	public String name;

	private TopupTypeEnum(String name) {
		this.name = name;
	}
}
