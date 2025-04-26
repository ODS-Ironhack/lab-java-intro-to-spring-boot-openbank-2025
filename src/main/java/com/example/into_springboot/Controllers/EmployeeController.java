package com.example.into_springboot.Controllers;

import com.example.into_springboot.Modules.Employee;
import com.example.into_springboot.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping
    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @GetMapping("/status/{status}")
    public List<Employee> findByStatus(@PathVariable Employee.Status status){
        return employeeRepo.findByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> findByDepartment(@PathVariable String department){
        return employeeRepo.findByDepartment(department);
    }
}
