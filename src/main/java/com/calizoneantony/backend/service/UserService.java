package com.calizoneantony.backend.service;

import com.calizoneantony.backend.dao.UserRepository;
import com.calizoneantony.backend.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean userExists(String subId) {
        return userRepository.existsBySubId(subId);
    }
}
