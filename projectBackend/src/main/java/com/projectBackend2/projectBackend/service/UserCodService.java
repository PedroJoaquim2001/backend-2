package com.projectBackend2.projectBackend.service;

import com.projectBackend2.projectBackend.repository.UserCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCodService {
    @Autowired
    private UserCodeRepository userCodeRepository;

}
