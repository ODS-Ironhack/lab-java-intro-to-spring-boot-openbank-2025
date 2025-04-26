package com.example.into_springboot.Controllers;

import com.example.into_springboot.Modules.Employee;
import com.example.into_springboot.Modules.Patient;
import com.example.into_springboot.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepo;

    @GetMapping
    public List<Patient> getAll(){
        return patientRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getById(@PathVariable Long id) {
        return patientRepo.findById(id);
    }

    @GetMapping("/dateOfBirth/{start}/{end}")
    public List<Patient> findByDateOfBirthBetween(
            @PathVariable LocalDate start,
            @PathVariable LocalDate end){
        return patientRepo.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/admittedBy/department/{department}")
    public List<Patient> findByAdmittedByDepartment(@PathVariable String department){
        return patientRepo.findByAdmittedBy_Department(department);
    }

    @GetMapping("/admittedBy/statusOff")
    public List<Patient> findByAdmittedBy_Status(){
        return patientRepo.findByAdmittedBy_Status(Employee.Status.OFF);
    }


}
