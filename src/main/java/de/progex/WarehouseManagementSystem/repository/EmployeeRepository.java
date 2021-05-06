package de.progex.WarehouseManagementSystem.repository;

import de.progex.WarehouseManagementSystem.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Integer, Employee> {

    Employee findEmployeeById(int id);
}