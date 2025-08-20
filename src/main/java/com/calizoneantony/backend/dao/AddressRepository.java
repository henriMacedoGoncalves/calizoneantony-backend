package com.calizoneantony.backend.dao;

import com.calizoneantony.backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
