package org.example.sgsejercicio.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.sgsejercicio.entities.Category;
import org.example.sgsejercicio.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/category")
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> save(@Valid @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEntity(category));
    }

    @PutMapping
    public ResponseEntity<Category> update(@Valid @RequestBody Category category){
        return ResponseEntity.ok(service.saveEntity(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
