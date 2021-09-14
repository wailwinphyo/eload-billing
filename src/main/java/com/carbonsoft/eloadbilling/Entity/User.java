package com.carbonsoft.eloadbilling.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DELL
 *
 */
@Entity
@Data @NoArgsConstructor
public class User implements UserDetails, Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String username;

	private String password;

	private String fullName;

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime modifiedAt;

	private boolean enabled = true;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> authorities = new HashSet<>();

	public User(Integer id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", fullName=" + fullName + ", createdAt=" + createdAt
				+ ", modifiedAt=" + modifiedAt + ", enabled=" + enabled + ", authorities=" + authorities + "]";
	}

}
