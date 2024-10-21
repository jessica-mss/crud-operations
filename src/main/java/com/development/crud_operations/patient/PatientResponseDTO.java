package com.development.crud_operations.patient;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDTO {

    private Long id;
    private String cpf;
    private String name;
    private String email;

    public static PatientResponseDTO convertToDTO(PatientEntity entity) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(entity.getId());
        patientResponseDTO.setCpf(entity.getCpf());
        patientResponseDTO.setName(entity.getName());
        patientResponseDTO.setEmail(entity.getEmail());
        return patientResponseDTO;
    }

}
