package com.projectBackend2.projectBackend.controller.form;

import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.model.ProductsModel;
import com.projectBackend2.projectBackend.model.status.CategoryStatus;
import com.projectBackend2.projectBackend.model.status.ProductStatus;
import com.projectBackend2.projectBackend.service.AdminsService;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductForm {
    @NotNull @NotEmpty
    private UUID admin_id;
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String product_name;
    @NotNull @Digits(integer = 12,fraction = 2)
    private double price;
    @NotNull @NotEmpty @Length(min = 4,max = 9)
    private CategoryStatus category;
    @NotNull @NotEmpty @Length(min = 9,max = 10)
    private ProductStatus status;


    public UUID getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(UUID admin_id) {
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

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public ProductsModel convert(AdminsService adminsService){
        AdminsModel adminsModel = adminsService.findById(admin_id).get();

        return new ProductsModel(adminsModel, product_name, price, category, status);
    }

}
