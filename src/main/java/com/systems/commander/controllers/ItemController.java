package com.systems.commander.controllers;

import com.systems.commander.dto.ItemRequest;
import com.systems.commander.dto.ItemResponse;
import com.systems.commander.mappers.ItemMapper;
import com.systems.commander.models.Item;
import com.systems.commander.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

  @Autowired private ItemService itemService;

  @Autowired private ItemMapper itemMapper;

  @PostMapping
  public ResponseEntity<ItemResponse> insertItem(@RequestBody ItemRequest itemRequest) {
    var item = itemService.insert(itemMapper.convertToModel(itemRequest), itemRequest.getCategoryId());
    var response = itemMapper.convertToResponse(item);

    var uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{itemId}")
            .buildAndExpand(response.getId())
            .toUri();

    return ResponseEntity.created(uri).body(response);
  }

  @GetMapping("/{itemId}")
  public ResponseEntity<Item> findById(@PathVariable UUID itemId) {
    var item = itemService.findById(itemId);
    return ResponseEntity.ok(item);
  }

  @GetMapping
  public ResponseEntity<Page<Item>> findAllItem(
      @RequestParam(required = false) Boolean enable, Pageable pageable) {
    var items = itemService.findAll(enable, pageable);
    return ResponseEntity.ok(items);
  }
}
