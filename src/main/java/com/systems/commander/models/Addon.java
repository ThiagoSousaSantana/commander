package com.systems.commander.models;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Addon {

  @Id private UUID id;
  private String name;
  private String description;
  private String imageUrl;
  private Boolean enabled;
  private BigDecimal price;

  @ManyToOne private Category category;

  @ManyToOne private Item item;

  @CreatedDate private long createdDate;

  @LastModifiedDate private long modifiedDate;
}
