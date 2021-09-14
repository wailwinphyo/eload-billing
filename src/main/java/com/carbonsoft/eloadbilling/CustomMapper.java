package com.carbonsoft.eloadbilling;

import org.springframework.stereotype.Component;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Model.UserDto;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class CustomMapper implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory factory) {
		factory.classMap(User.class, UserDto.class)
				.fieldMap("username", "phoneNumber").add()
				.fieldMap("fullName", "name").add()
				.exclude("pinNumber").byDefault().register();

		factory.classMap(UserDto.class, User.class)
				.fieldMap("phoneNumber", "username").add()
				.fieldMap("pinNumber", "password").add()
				.fieldMap("name", "fullName").add().byDefault().register();

	}
}
