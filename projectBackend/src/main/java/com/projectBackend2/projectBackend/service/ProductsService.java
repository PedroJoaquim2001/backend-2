package com.projectBackend2.projectBackend.service;

import com.projectBackend2.projectBackend.model.ProductsModel;
import com.projectBackend2.projectBackend.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Transactional
    public ProductsModel save(ProductsModel productsModel){

        return productsRepository.save(productsModel);
    }

    public Optional<ProductsModel> findById(UUID id){
        return productsRepository.findById(id);
    }
    @Transactional
    public void delete(ProductsModel productsModel){
        productsRepository.delete(productsModel);
    }

}
