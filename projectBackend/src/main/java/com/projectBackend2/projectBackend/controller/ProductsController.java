package com.projectBackend2.projectBackend.controller;

import com.projectBackend2.projectBackend.controller.dto.ProductDto;
import com.projectBackend2.projectBackend.controller.form.ProductForm;
import com.projectBackend2.projectBackend.model.ProductsModel;
import com.projectBackend2.projectBackend.service.AdminsService;
import com.projectBackend2.projectBackend.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private AdminsService adminsService;


    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder){
        ProductsModel product = form.convert(adminsService);
        productsService.save(product);

        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id){
        Optional<ProductsModel> productsModelOptional = productsService.findById(id);
        if(!productsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ProductDto(productsModelOptional.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable UUID id){
        Optional<ProductsModel> productsModelOptional = productsService.findById(id);
        if (!productsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product to delete not found.");
        }
        productsService.delete(productsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID id, @RequestBody @Valid ProductForm form){
        Optional<ProductsModel> productsModelOptional = productsService.findById(id);
        if (!productsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product to update not found.");
        }
        var product = new ProductsModel();
        BeanUtils.copyProperties(form, product);
        product = form.convert(adminsService);
        product.setId(productsModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(productsService.save(product));
    }
}
