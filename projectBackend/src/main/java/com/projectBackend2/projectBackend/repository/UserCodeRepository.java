package com.projectBackend2.projectBackend.repository;


import com.projectBackend2.projectBackend.model.UserCodModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserCodeRepository extends JpaRepository<UserCodModel, UUID> {
    Optional<UserCodModel> findById(UUID id);

}
