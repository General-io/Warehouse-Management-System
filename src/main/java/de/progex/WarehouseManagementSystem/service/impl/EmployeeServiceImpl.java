package de.progex.WarehouseManagementSystem.service.impl;

import de.progex.WarehouseManagementSystem.repository.EmployeeRepository;
import de.progex.WarehouseManagementSystem.service.EmployeeService;
import de.progex.WarehouseManagementSystem.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Qualifier("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id);
    }
}
