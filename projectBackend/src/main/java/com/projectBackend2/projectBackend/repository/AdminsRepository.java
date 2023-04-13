package com.projectBackend2.projectBackend.repository;

import com.projectBackend2.projectBackend.model.AdminsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AdminsRepository extends JpaRepository<AdminsModel, UUID> {
    Optional<AdminsModel> findById( UUID id);
}
