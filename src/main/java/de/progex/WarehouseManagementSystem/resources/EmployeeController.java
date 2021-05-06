package de.progex.WarehouseManagementSystem.resources;

import de.progex.WarehouseManagementSystem.Service.impl.EmployeeServiceImpl;
import de.progex.WarehouseManagementSystem.tables.Employee;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws NotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    @GetMapping("byEmplId/{employeeId}")
    public ResponseEntity<Employee> getEmployeeByEmployeeId(@PathVariable int employeeId) throws NotFoundException {
        Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    @GetMapping("all")
    public ResponseEntity<List> getAllEmployee(){
        List<Employee> allEmployee = new ArrayList<>();
        allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.ACCEPTED);
    }

    @PostMapping("add")
    public HttpStatus addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("put/{id}")
    public HttpStatus updateEmployee(@PathVariable int id,
                                     @RequestParam String firstname) throws NotFoundException {
        employeeService.updateEmployee(id, firstname);
        return HttpStatus.ACCEPTED;
    }
}
