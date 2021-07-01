package de.progex.WarehouseManagementSystem.resources;

import de.progex.WarehouseManagementSystem.Service.EmployeeService;
import de.progex.WarehouseManagementSystem.Service.impl.EmployeeServiceImpl;
import de.progex.WarehouseManagementSystem.tables.Employee;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
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
                                     @RequestBody Employee employee) throws NotFoundException {  // put/1&firstname=beispiel
        employeeService.updateEmployee(id, employee);
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping("delete/{id}")
    public HttpStatus deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
        return HttpStatus.ACCEPTED;
    }
}
