package com.calizoneantony.backend.dao;

import com.calizoneantony.backend.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
}
