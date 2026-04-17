package org.example.sgsejercicio.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.sgsejercicio.entities.Product;
import org.example.sgsejercicio.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product saveEntity(Product product){
        return repository.save(product);
    }

    public Product updateEntity(Product product){
        return repository.save(product);
    }

    public List<Product> listAll(){
        List<Product> list = repository.findAll();
        if (list.isEmpty()){
            throw new EntityNotFoundException("No se encuentran items");
        }
        return list;
    }

    public Product findById(Long id){
        return repository.findById(id).orElseThrow(()->{
            return new EntityNotFoundException("No se encuentra un item con ese identificador");
        });
    }

    public void delete(Long id){
        if (!repository.existsById(id)) throw new EntityNotFoundException("No se pudo eliminar el item");
        repository.deleteById(id);
    }
}
