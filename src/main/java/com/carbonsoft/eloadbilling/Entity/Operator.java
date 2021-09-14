package com.carbonsoft.eloadbilling.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Operator {

	public Operator(Integer id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue
	public Integer id;

	public String name;

	public String topupType;

	public String status;

}
