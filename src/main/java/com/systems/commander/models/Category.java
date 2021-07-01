package com.systems.commander.models;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Category {

  @Id private UUID id;
  private String name;
  private Boolean enable;

  @CreatedDate private long createdDate;

  @LastModifiedDate private long modifiedDate;
}
