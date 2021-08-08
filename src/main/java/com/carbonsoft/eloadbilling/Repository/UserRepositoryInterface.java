package com.carbonsoft.eloadbilling.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.carbonsoft.eloadbilling.Models.User;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {

}
