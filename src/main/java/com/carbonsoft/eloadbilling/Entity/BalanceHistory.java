package com.carbonsoft.eloadbilling.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class BalanceHistory extends History {
	
	public BalanceHistory(Integer userid, Integer balance, Integer mobileNumber, String status, String description) {
		this.user = new User(userid);
		this.balance = balance;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.description = description;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	private User user;
	
	private Integer mobileNumber;
	
	private Integer balance;
	
	private String status;
	
	private String description;

}
