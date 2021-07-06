package com.systems.commander.repositories;

import com.systems.commander.models.Item;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    Page<Item> findAllByEnabledTrue(Pageable pageable);

}
