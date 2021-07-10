package com.systems.commander.services;

import com.systems.commander.models.Item;
import com.systems.commander.repositories.ItemRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemService {

  @Autowired private ItemRepository itemRepository;

  @Autowired private CategoryService categoryService;

  public Item insert(Item item, UUID categoryId) {
    var category = categoryService.findById(categoryId);
    item.generateId();
    item.setEnabled(true);
    item.setCategory(category);
    return itemRepository.save(item);
  }

  public Item findById(UUID id) {
    return itemRepository.findById(id)
            .orElseThrow(() -> new ObjectNotFoundException(id, "Item"));
  }

  public Page<Item> findAll(Boolean enable, Pageable pageable) {
    if (enable == null || enable){
      return itemRepository.findAll(pageable);
    }
    return itemRepository.findAllByEnabledTrue(pageable);
  }
}
