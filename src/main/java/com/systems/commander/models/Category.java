package com.systems.commander.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Category {

  @Id
  @Setter(AccessLevel.PRIVATE)
  private UUID id;

  private String name;
  private Boolean enable;

  @OneToMany(mappedBy = "category")
  private List<Item> items;

  @CreatedDate
  private long createdDate;

  @LastModifiedDate
  private long modifiedDate;

  public void generateId() {
    this.id = UUID.randomUUID();
  }
}
