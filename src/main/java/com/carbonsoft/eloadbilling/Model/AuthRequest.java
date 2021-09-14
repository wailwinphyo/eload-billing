package com.carbonsoft.eloadbilling.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AuthRequest {

	private String phoneNumber;
	private String pinNumber;
}
