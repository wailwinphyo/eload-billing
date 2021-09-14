package com.carbonsoft.eloadbilling.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Role implements GrantedAuthority {

	/*
	 * public static final String USER = "USER"; public static final String ADMIN =
	 * "ADMIN";
	 */
    
    @Id
    private Integer id;

    private String authority;

}
