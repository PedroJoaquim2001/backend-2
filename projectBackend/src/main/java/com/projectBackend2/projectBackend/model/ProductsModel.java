package com.projectBackend2.projectBackend.model;

import com.projectBackend2.projectBackend.model.status.CategoryStatus;
import com.projectBackend2.projectBackend.model.status.ProductStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PRODUCTS")
public class ProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminsModel admin_id;
    @Column(nullable = false, length = 50)
    private String product_name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private CategoryStatus category;
    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();
    @Column(nullable = false)
    private ProductStatus status;

    public ProductsModel(){
    }

    public ProductsModel(AdminsModel admin_id, String product_name, double price, CategoryStatus category, ProductStatus status) {
        this.admin_id = admin_id;
        this.product_name = product_name;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AdminsModel getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(AdminsModel admin_id) {
        this.admin_id = admin_id;
    }

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
    
}
