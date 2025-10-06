package com.calizoneantony.backend.service;

import com.calizoneantony.backend.dao.EbookRepository;
import com.calizoneantony.backend.entity.Ebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookRepository ebookRepository;

    public List<Ebook> getEbooks() {
        return ebookRepository.findAll();
    }
}
