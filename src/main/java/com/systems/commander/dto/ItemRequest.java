package com.systems.commander.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequest {

  private String name;
  private String description;
  private BigDecimal price;
  private String classification;
  private String size;
  private String imageUrl;
  private String rating;
  private UUID category;
}