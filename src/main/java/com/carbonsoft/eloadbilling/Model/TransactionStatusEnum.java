package com.carbonsoft.eloadbilling.Model;

import lombok.Getter;

@Getter
public enum TransactionStatusEnum {
	in("IN"), out("OUT");

	private String name;

	TransactionStatusEnum(String name) {
		this.name = name;
	}
}
