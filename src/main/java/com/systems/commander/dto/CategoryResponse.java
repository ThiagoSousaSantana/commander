package com.systems.commander.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class CategoryResponse {
  private UUID id;
  private String name;
  private Boolean enable;
}
