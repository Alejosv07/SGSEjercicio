package org.example.sgsejercicio.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.sgsejercicio.entities.Category;
import org.example.sgsejercicio.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public Category saveEntity(Category category){
        return repository.save(category);
    }

    public Category updateEntity(Category category){
        return repository.save(category);
    }

    public List<Category> listAll(){
        List<Category> list = repository.findAll();
        if (list.isEmpty()){
            throw new EntityNotFoundException("No se encuentran items");
        }
        return list;
    }

    public Category findById(Long id){
        return repository.findById(id).orElseThrow(()->{
           return new EntityNotFoundException("No se encuentra un item con ese identificador");
        });
    }

    public void delete(Long id){
        if (!repository.existsById(id)) throw new EntityNotFoundException("No se pudo eliminar el item");
        repository.deleteById(id);
    }

}
