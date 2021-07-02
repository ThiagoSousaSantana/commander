package com.systems.commander.controllers;

import com.systems.commander.dto.CategoryRequest;
import com.systems.commander.dto.CategoryResponse;
import com.systems.commander.mappers.CategoryMapper;
import com.systems.commander.services.CategoryService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryService service;

  @Autowired
  private CategoryMapper mapper;

  @PostMapping
  public ResponseEntity<CategoryResponse> insertCategory(@RequestBody CategoryRequest request) {
    var category = service.insertCategory(mapper.convertToModel(request));
    var response = mapper.convertToResponse(category);

    var uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{categoryId}")
            .buildAndExpand(response.getId())
            .toUri();

    return ResponseEntity.created(uri).body(response);
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable UUID categoryId) {
    var category = service.findById(categoryId);
    return ResponseEntity.ok(mapper.convertToResponse(category));
  }

  @GetMapping
  public ResponseEntity<List<CategoryResponse>> getAllCategories(
      @RequestParam(required = false) boolean enabled) {

    var categories = service.findAll(enabled).stream()
        .map(category -> mapper.convertToResponse(category))
        .collect(Collectors.toList());

    return ResponseEntity.ok(categories);
  }
}
