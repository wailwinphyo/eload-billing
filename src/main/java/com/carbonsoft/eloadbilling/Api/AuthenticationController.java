package com.carbonsoft.eloadbilling.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Model.AuthRequest;
import com.carbonsoft.eloadbilling.Model.UserDto;
import com.carbonsoft.eloadbilling.security.JwtTokenUtil;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private MapperFacade mapper;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authReq) throws Exception {
		try {
			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getPhoneNumber(), authReq.getPinNumber()));

			final User userDetails = (User) authenticate.getPrincipal();

			final String jwt = jwtTokenUtil.generateAccessToken(userDetails);

			return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt)
					.body(mapper.map(userDetails, UserDto.class));
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
