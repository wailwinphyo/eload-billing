package com.carbonsoft.eloadbilling.Api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Model.OperatorDto;
import com.carbonsoft.eloadbilling.Model.TopupDto;
import com.carbonsoft.eloadbilling.Model.TopupPackageDto;
import com.carbonsoft.eloadbilling.Model.UserBalanceDto;
import com.carbonsoft.eloadbilling.Service.TopUpService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
@Api(tags = { "Topup Controller" })
public class TopUpController {

	@Autowired
	TopUpService topupService;

	@GetMapping("/operators")
	public List<OperatorDto> getAllOperators() {
		List<OperatorDto> allOperator = topupService.getAllOperator();
		return allOperator;
	}
	
	@GetMapping("/operators/{operatorid}/packages")
	public List<TopupPackageDto> getAvailablePackages(@PathVariable("operatorid")Integer operatorId){
		return topupService.getAllAvailablePackages(operatorId);
	}
	
	@PostMapping("/topup")
	public ResponseEntity<?> buyTopupPackage(@RequestBody TopupDto topupDto) throws Exception {
		TopupPackageDto topup = topupService.buyTopupPackage(topupDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/balance")
				.build().toUri();
		return ResponseEntity.ok(location);
	}
	
	@GetMapping("/balance")
	public UserBalanceDto getUserBalance() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserBalanceDto userBal = topupService.getBalanceDetail(user);
		return userBal;
	}
}
