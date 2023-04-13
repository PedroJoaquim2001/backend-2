package com.projectBackend2.projectBackend.service;

import com.projectBackend2.projectBackend.model.EmployeesModel;
import com.projectBackend2.projectBackend.repository.EmployeesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    @Transactional
    public EmployeesModel save(EmployeesModel employeesModel){

        return employeesRepository.save(employeesModel);
    }

    public Optional<EmployeesModel> findById(UUID id){
        return employeesRepository.findById(id);
    }

    @Transactional
    public void delete(EmployeesModel employeesModel){
        employeesRepository.delete(employeesModel);
    }
}
