package com.example.cabinet.service;

import com.example.cabinet.db.Patient;
import com.example.cabinet.db.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getList() {
        return this.patientRepository.findAll();
    }

    public Page<Patient> getList(Pageable pageable) {
        return this.patientRepository.findAll(pageable);
    }

    public Patient addPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    public Patient findPatientById(Long id) {
        return this.patientRepository.findById(id).orElse(null);
    }

    public void deletePatient(Patient patient) {
        this.patientRepository.delete(patient);
    }


}
