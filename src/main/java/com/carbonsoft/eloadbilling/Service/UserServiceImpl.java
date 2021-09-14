package com.carbonsoft.eloadbilling.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Exception.UserNotFoundException;
import com.carbonsoft.eloadbilling.Model.UserDto;
import com.carbonsoft.eloadbilling.Repository.UserRepository;

import ma.glasnost.orika.MapperFacade;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MapperFacade mapper;

	@Override
	public User SaveUser(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
//		user.setRole(Role.USER);
//		user.setStatus(StatusEnum.active.getName());

		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public UserDto getUserDetail(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id - " + id);
		User us = user.get();
		UserDto userDto = mapper.map(us, UserDto.class);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = mapper.mapAsList(users, UserDto.class);
		return userDtos;
	}
}
