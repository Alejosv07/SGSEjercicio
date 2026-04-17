package org.example.sgsejercicio.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.sgsejercicio.entities.Product;
import org.example.sgsejercicio.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEntity(product));
    }

    @PutMapping
    public ResponseEntity<Product> update(@Valid @RequestBody Product product){
        return ResponseEntity.ok(service.saveEntity(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
