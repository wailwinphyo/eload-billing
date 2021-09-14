package com.carbonsoft.eloadbilling.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carbonsoft.eloadbilling.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}
