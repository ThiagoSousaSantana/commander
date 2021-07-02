package com.systems.commander.mappers;

import com.systems.commander.dto.CategoryRequest;
import com.systems.commander.dto.CategoryResponse;
import com.systems.commander.models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

  @Autowired
  private ModelMapper modelMapper;

  public Category convertToModel(CategoryRequest request) {
    return modelMapper.map(request, Category.class);
  }

  public CategoryResponse convertToResponse(Category category) {
    return modelMapper.map(category, CategoryResponse.class);
  }
}
