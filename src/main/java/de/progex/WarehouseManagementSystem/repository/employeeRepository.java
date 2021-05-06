package de.progex.WarehouseManagementSystem.repository;

import de.progex.WarehouseManagementSystem.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<Long, Employee> {
}
