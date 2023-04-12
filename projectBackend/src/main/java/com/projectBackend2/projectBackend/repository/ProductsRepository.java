package com.projectBackend2.projectBackend.repository;

import com.projectBackend2.projectBackend.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<ProductsModel, UUID> {
    Optional<ProductsModel> findById(UUID id);
}
