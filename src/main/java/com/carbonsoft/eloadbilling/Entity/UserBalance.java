package com.carbonsoft.eloadbilling.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserBalance extends History{

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer balance;
	
	private String status;
	
	@ManyToOne
	private User user;
}
