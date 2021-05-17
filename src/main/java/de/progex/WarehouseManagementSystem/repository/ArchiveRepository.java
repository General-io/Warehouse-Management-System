package de.progex.WarehouseManagementSystem.repository;

import de.progex.WarehouseManagementSystem.tables.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {
}
