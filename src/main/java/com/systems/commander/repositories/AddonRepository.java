package com.systems.commander.repositories;

import com.systems.commander.models.Addon;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddonRepository extends JpaRepository<Addon, UUID> {

}
