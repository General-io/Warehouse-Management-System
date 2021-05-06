package de.progex.WarehouseManagementSystem.resources;

import de.progex.WarehouseManagementSystem.service.impl.EmployeeServiceImpl;
import de.progex.WarehouseManagementSystem.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(@Qualifier("EmployeeService")EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("'{id}'")
    public ResponseEntity<Employee> getEmployee(@RequestHeader int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


    /*
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        authenticate(user.getUsername(), user.getPassword());
        User loginUser = userService.findUserByUsername(user.getUsername());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(loginUser, jwtHeader, HttpStatus.OK);
    }*/
}
