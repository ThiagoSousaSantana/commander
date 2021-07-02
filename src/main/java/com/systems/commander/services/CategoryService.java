package com.systems.commander.services;

import com.systems.commander.models.Category;
import com.systems.commander.repositories.CategoryRepository;
import java.util.List;
import java.util.UUID;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public Category insertCategory(Category category) {
    category.generateId();
    category.setEnable(true);
    return repository.save(category);
  }

  public Category findById(UUID id) {
    return repository.findById(id)
        .orElseThrow(() -> new ObjectNotFoundException(id, "Category"));
  }

  public List<Category> findAll(boolean enabled) {
    if (enabled) {
      return repository.findAllByEnableTrue();
    }
    return repository.findAll();
  }
}
