package de.progex.WarehouseManagementSystem.repository;

import de.progex.WarehouseManagementSystem.tables.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
