package com.carbonsoft.eloadbilling.Service;

import java.util.List;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Model.OperatorDto;
import com.carbonsoft.eloadbilling.Model.TopupDto;
import com.carbonsoft.eloadbilling.Model.TopupPackageDto;
import com.carbonsoft.eloadbilling.Model.UserBalanceDto;

public interface TopUpService {

	public List<OperatorDto> getAllOperator();

	List<TopupPackageDto> getAllAvailablePackages(Integer id);

	public TopupPackageDto buyTopupPackage(TopupDto topupDto) throws Exception;

	UserBalanceDto getBalanceDetail(User user);
}
