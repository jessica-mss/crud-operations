package com.development.crud_operations.patient;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<PatientResponseDTO> findAll() {
        List<PatientEntity> findAll = repository.findAll();
//        return List.of(PatientResponseDTO.convertToDTO(findAll));
        return findAll.stream()
                .map(PatientResponseDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}
