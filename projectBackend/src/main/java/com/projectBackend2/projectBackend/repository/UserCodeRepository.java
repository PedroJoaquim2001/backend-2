package com.projectBackend2.projectBackend.repository;


import com.projectBackend2.projectBackend.model.UserCodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserCodeRepository extends JpaRepository<UserCodModel, UUID> {
    Optional<UserCodModel> findById(UUID id);

}
