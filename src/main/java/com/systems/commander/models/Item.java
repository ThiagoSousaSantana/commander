package com.systems.commander.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Item {

  @Id private UUID id;
  private String name;
  private String description;
  private BigDecimal price;
  private String classification;
  private String size;
  private String imageUrl;
  private String rating;
  private Boolean enabled;

  @ManyToOne private Category category;

  @JsonIgnore
  @OneToMany(mappedBy = "item")
  private List<Flavor> flavors;

  @JsonIgnore
  @OneToMany(mappedBy = "item")
  private List<Addon> addons;

  @CreatedDate private long createdDate;

  @LastModifiedDate private long modifiedDate;

  public void generateId() {
    this.id = UUID.randomUUID();
  }
}
