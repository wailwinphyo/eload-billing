package com.carbonsoft.eloadbilling.Controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carbonsoft.eloadbilling.Exceptions.UserNotFoundException;
import com.carbonsoft.eloadbilling.Models.User;
import com.carbonsoft.eloadbilling.Models.Enums.RoleEnum;
import com.carbonsoft.eloadbilling.Models.Enums.StatusEnum;
import com.carbonsoft.eloadbilling.Repository.UserRepositoryInterface;

@RestController
public class UserController {

	@Autowired
	private UserRepositoryInterface userRepository;

	@PostMapping("/users")
	public ResponseEntity<?> CreateUser(@RequestBody User user) {
		user.setRole(RoleEnum.user);
		user.setStatus(StatusEnum.active);
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}")
	public User getUsers(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id - " + id);

		return user.get();
	}

}
