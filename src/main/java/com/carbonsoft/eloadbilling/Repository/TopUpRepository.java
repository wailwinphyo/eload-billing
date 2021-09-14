package com.carbonsoft.eloadbilling.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carbonsoft.eloadbilling.Entity.Operator;
import com.carbonsoft.eloadbilling.Entity.TopupPackage;

public interface TopUpRepository extends JpaRepository<TopupPackage, Integer> {

	@Query(value = "SELECT t FROM TopupPackage t WHERE t.operator = ?1 and t.status = ?2")
	List<TopupPackage> findbyOperator(Operator operator, String status);
}
