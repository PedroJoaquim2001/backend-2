package com.projectBackend2.projectBackend.service;

import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.repository.AdminsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminsService {

    @Autowired
    private AdminsRepository adminsRepository;

    @Transactional
    public AdminsModel save(AdminsModel adminsModel){

        return adminsRepository.save(adminsModel);
    }

    public Optional<AdminsModel> findById(UUID id){
        return adminsRepository.findById(id);
    }

    @Transactional
    public void delete(AdminsModel adminsModel){
        adminsRepository.delete(adminsModel);
    }

}
