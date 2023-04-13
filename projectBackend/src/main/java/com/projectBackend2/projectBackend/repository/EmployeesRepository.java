package com.projectBackend2.projectBackend.repository;

import com.projectBackend2.projectBackend.model.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesModel, UUID> {
    Optional<EmployeesModel> findById(UUID id);
}
