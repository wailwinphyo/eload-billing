package com.carbonsoft.eloadbilling.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.carbonsoft.eloadbilling.Entity.BalanceHistory;
import com.carbonsoft.eloadbilling.Entity.Operator;
import com.carbonsoft.eloadbilling.Entity.TopupPackage;
import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Entity.UserBalance;
import com.carbonsoft.eloadbilling.Exception.InvalidBalanceException;
import com.carbonsoft.eloadbilling.Model.OperatorDto;
import com.carbonsoft.eloadbilling.Model.StatusEnum;
import com.carbonsoft.eloadbilling.Model.TopupDto;
import com.carbonsoft.eloadbilling.Model.TopupPackageDto;
import com.carbonsoft.eloadbilling.Model.TransactionStatusEnum;
import com.carbonsoft.eloadbilling.Model.UserBalanceDto;
import com.carbonsoft.eloadbilling.Repository.BalanceHistoryRepository;
import com.carbonsoft.eloadbilling.Repository.OperatorRepository;
import com.carbonsoft.eloadbilling.Repository.TopUpRepository;
import com.carbonsoft.eloadbilling.Repository.UserBalanceRepository;

import ma.glasnost.orika.MapperFacade;

@Service
public class TopUpServiceImpl implements TopUpService {

	@Autowired
	TopUpRepository topUpRepository;
	
	@Autowired
	OperatorRepository operatorRepository;
	
	@Autowired
	UserBalanceRepository userBalanceRepository;
	
	@Autowired
	BalanceHistoryRepository balanceRepository;

	@Autowired
	MapperFacade mapper;

	@Override
	public List<OperatorDto> getAllOperator() {
		Operator op = new Operator();
		op.setStatus(StatusEnum.active.getName());
		Example<Operator> example = Example.of(op);
		List<Operator> operators = operatorRepository.findAll(example);

		return mapper.mapAsList(operators, OperatorDto.class);
	}
	
	@Override
	public List<TopupPackageDto> getAllAvailablePackages(Integer id){
		List<TopupPackage> topupPackages = topUpRepository.findbyOperator(new Operator(id), StatusEnum.active.getName());
		return mapper.mapAsList(topupPackages, TopupPackageDto.class);
	}

	@Override
	public TopupPackageDto buyTopupPackage(TopupDto topupDto) throws Exception {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserBalance userBal = userBalanceRepository.findById(user.getId()).get();
		TopupPackage packageDetail = topUpRepository.findById(topupDto.getPackageId()).get();
		
		CheckBalance(userBal, packageDetail);
		Integer remainingBal = userBal.getBalance() - packageDetail.getPrice();
		userBal.setBalance(remainingBal);
		userBalanceRepository.save(userBal);
		
		BalanceHistory balHist = new BalanceHistory(user.getId(), packageDetail.getPrice(), topupDto.getMobileNumber(), TransactionStatusEnum.out.getName(), String.format("Buy package : %s", packageDetail.getName()));
		balanceRepository.save(balHist);
		
		return mapper.map(packageDetail, TopupPackageDto.class);
	}

	private void CheckBalance(UserBalance userBal, TopupPackage packageDetail) throws InvalidBalanceException {
		if(userBal.getBalance() < packageDetail.price) throw new InvalidBalanceException("Balance not enough");
	}

	@Override
	public UserBalanceDto getBalanceDetail(User user) {
		UserBalance userBal = userBalanceRepository.findByUser(user);
		return mapper.map(userBal, UserBalanceDto.class);
	}

}
