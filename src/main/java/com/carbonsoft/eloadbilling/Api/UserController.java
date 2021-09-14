package com.carbonsoft.eloadbilling.Api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Model.UserDto;
import com.carbonsoft.eloadbilling.Service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(tags = { "User" })
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
		User savedUser = userService.SaveUser(userDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}")
	public UserDto getUsers(@PathVariable("id") Integer id) {
		UserDto userDto = userService.getUserDetail(id);
		return userDto;
	}

	@GetMapping("/users")
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = userService.getAllUsers();
		return userDtos;
	}

}
