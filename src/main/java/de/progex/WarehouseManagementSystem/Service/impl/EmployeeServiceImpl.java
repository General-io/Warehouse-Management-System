package de.progex.WarehouseManagementSystem.Service.impl;

import de.progex.WarehouseManagementSystem.Service.EmployeeService;
import de.progex.WarehouseManagementSystem.repository.EmployeeRepository;
import de.progex.WarehouseManagementSystem.tables.Employee;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
@Qualifier("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(int id) throws NotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + id + " does not exists"

                ));
        return employee;
    }

    @Override
    public Employee getEmployeeByEmployeeId(long employeeId) throws NotFoundException {
        Employee employee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if (employee  == null) {
            LOGGER.error("Employee Not Found By Id: " + employeeId);
            throw new NotFoundException("");
        }else return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional  // durch transactional wird das Employeeobject das hier benutzt wird auch direkt in der datenbank veränderrt
    public void updateEmployee(int id, Employee newEmployee) throws NotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + id + " does not exists"
                ));
        if (newEmployee.getFirstname() != "")
        employee.setFirstname(newEmployee.getFirstname());
        if (newEmployee.getDepartment() != "")
        employee.setDepartment(newEmployee.getDepartment());
        if (newEmployee.getLastName() != "")
        employee.setLastName(newEmployee.getLastName());
        if (newEmployee.getStreet() != "")
        employee.setStreet(newEmployee.getStreet());
        if (newEmployee.getStreetNo() != 0)
        employee.setStreetNo(newEmployee.getStreetNo());
        if (newEmployee.getCountry() != "")
        employee.setCountry(newEmployee.getCountry());
        if (newEmployee.getTelephone() != 0)
        employee.setTelephone(newEmployee.getTelephone());
        if (newEmployee.getOrt() != "")
        employee.setOrt(newEmployee.getOrt());
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + id + " does not exists"
                ));
        employeeRepository.delete(employee);
    }
}
