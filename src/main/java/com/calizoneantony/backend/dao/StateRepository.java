package com.calizoneantony.backend.dao;

import com.calizoneantony.backend.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
