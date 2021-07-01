package com.systems.commander.repositories;

import com.systems.commander.models.Flavor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavorRepository extends JpaRepository<Flavor, UUID> {

}
