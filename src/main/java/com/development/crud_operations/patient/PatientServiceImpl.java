package com.development.crud_operations.patient;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository repository;

    @Override
    public PatientResponseDTO findById(Long id) {
        PatientEntity patientEntity = repository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Paciente não encontrado"));
        return PatientResponseDTO.convertToDTO(patientEntity);
    }
}
