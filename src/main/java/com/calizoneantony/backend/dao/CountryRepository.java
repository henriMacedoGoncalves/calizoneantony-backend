package com.calizoneantony.backend.dao;

import com.calizoneantony.backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
