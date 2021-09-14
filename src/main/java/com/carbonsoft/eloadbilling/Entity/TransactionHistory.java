package com.carbonsoft.eloadbilling.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Entity
@Getter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class TransactionHistory extends History {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private TopupPackage topupPackage;

}
