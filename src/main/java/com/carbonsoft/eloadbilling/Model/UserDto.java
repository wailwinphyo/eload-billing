package com.carbonsoft.eloadbilling.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author DELL
 *
 */

@ApiModel(description = "All about the user")
@Getter
@Setter
public class UserDto {

	@ApiModelProperty(example = "79605662")
	@NotNull
	@Pattern(regexp = "[\\d]{5,}", message = "Phone Number should be more than 5 digits")
	private String phoneNumber;

	@ApiModelProperty(example = "123456")
	@NotNull
	@Pattern(regexp = "[\\d]{6}", message = "Pin  must be 6 digits")
	private String pinNumber;

	@ApiModelProperty(example = "Jack")
	@NotNull
	@Size(min = 4)
	private String name;

	public UserDto() {
	}

	public UserDto(String phoneNumber, String name) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDto [phoneNumber=" + phoneNumber + ", pinNumber=" + pinNumber + ", name=" + name + "]";
	}

}
