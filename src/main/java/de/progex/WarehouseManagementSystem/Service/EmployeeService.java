package de.progex.WarehouseManagementSystem.Service;

import de.progex.WarehouseManagementSystem.tables.Employee;
import javassist.NotFoundException;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeById(int id) throws NotFoundException;

    public Employee getEmployeeByEmployeeId(long employeeId) throws NotFoundException;

    public List<Employee> getAllEmployee();

    public void addEmployee(Employee employee);

    public void updateEmployee(int id, Employee employee) throws NotFoundException;

    public void deleteEmployeeById(int id);

}
