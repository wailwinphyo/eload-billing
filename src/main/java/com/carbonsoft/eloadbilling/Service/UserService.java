package com.carbonsoft.eloadbilling.Service;

import java.util.List;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Model.UserDto;

public interface UserService {

	User SaveUser(UserDto userDto);

	UserDto getUserDetail(Integer id);

	List<UserDto> getAllUsers();

}