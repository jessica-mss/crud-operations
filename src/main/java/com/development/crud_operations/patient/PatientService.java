package com.development.crud_operations.patient;

import java.util.List;

public interface PatientService {

    PatientResponseDTO findById(Long id);
    List<PatientResponseDTO> findAll();
}
