package com.backend.BackendSecurity.dtos;

import com.backend.BackendSecurity.models.UserModel;
import com.backend.BackendSecurity.models.enums.CategoryStatus;
import com.backend.BackendSecurity.models.enums.ProductStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductDto {
    /*@NotBlank
    private UserModel user_id;*/
    @NotBlank @Length(min = 1,max = 35)
    private String product_name;
    @NotBlank @Digits(integer = 12,fraction = 2)
    private double price;
    @NotBlank @Length(min = 4,max = 9)
    private CategoryStatus category;
    @NotBlank @Length(min = 9,max = 10)
    private ProductStatus status;

    /*public UserModel getUser_id() {
        return user_id;
    }

    public void setUser_id(UserModel user_id) {
        this.user_id = user_id;
    }*/

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryStatus getCategory() {
        return category;
    }

    public void setCategory(CategoryStatus category) {
        this.category = category;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
