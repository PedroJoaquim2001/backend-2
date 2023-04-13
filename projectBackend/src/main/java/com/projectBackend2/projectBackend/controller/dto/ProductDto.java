package com.projectBackend2.projectBackend.controller.dto;

import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.model.ProductsModel;
import com.projectBackend2.projectBackend.model.status.CategoryStatus;
import com.projectBackend2.projectBackend.model.status.ProductStatus;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductDto {
    private UUID admin_id;
    private String admin_name;
    private String product_name;
    private double price;
    private CategoryStatus category;
    private ProductStatus status;

    public ProductDto(ProductsModel productsModel){
        this.admin_id = productsModel.getAdmin_id().getId();
        this.admin_name = productsModel.getAdmin_id().getName();
        this.product_name = productsModel.getProduct_name();
        this.price = productsModel.getPrice();
        this.category = productsModel.getCategory();
        this.status = productsModel.getStatus();
    }

    public UUID getAdmin_id() {
        return admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getPrice() {
        return price;
    }

    public CategoryStatus getCategory() {
        return category;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public static List<ProductDto> convert(List<ProductsModel> productsModels){
        return productsModels.stream().map(ProductDto::new).collect(Collectors.toList());
    }

}
