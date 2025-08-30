package com.calizoneantony.backend.dao;

import com.calizoneantony.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Boolean existsBySubId(String subId);
}
