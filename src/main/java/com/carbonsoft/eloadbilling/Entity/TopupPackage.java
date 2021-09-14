package com.carbonsoft.eloadbilling.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TopupPackage {
	
	@Id
	@GeneratedValue
	public Integer id;
	
	public String name;
	
	public Integer price;
	
	public String description;
	
	@ManyToOne
	@JoinColumn(name = "operator_id")
	public Operator operator;
	
	public String status;
}
