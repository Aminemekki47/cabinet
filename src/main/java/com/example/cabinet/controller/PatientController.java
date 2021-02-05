package com.example.cabinet.controller;

import com.example.cabinet.db.Patient;
import com.example.cabinet.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> getList() {
        return this.patientService.getList();
    }

    @GetMapping("/page")
    public Page<Patient> getList(Pageable pageable) {
        return this.patientService.getList(pageable);
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return this.patientService.addPatient(patient);
    }

    @PutMapping
    public Patient editPatient(@RequestBody Patient patient) {
        return this.patientService.addPatient(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Patient patientById = this.patientService.findPatientById(id);
        this.patientService.deletePatient(patientById);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return this.patientService.findPatientById(id);
    }

}
