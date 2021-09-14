package com.carbonsoft.eloadbilling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carbonsoft.eloadbilling.Entity.User;
import com.carbonsoft.eloadbilling.Entity.UserBalance;

public interface UserBalanceRepository extends JpaRepository<UserBalance, Integer> {
	UserBalance findByUser(User user);
}
