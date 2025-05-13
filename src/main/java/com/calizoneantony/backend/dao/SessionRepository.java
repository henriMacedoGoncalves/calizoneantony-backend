package com.calizoneantony.backend.dao;

import com.calizoneantony.backend.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
