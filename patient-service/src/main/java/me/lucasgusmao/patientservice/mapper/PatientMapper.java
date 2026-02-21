package me.lucasgusmao.patientservice.mapper;

import me.lucasgusmao.patientservice.dto.PatientResponseDTO;
import me.lucasgusmao.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientResponseDTO;
    }

    public static Patient toEntity(PatientResponseDTO patientResponseDTO) {
        Patient patient = new Patient();
        patient.setId(java.util.UUID.fromString(patientResponseDTO.getId()));
        patient.setName(patientResponseDTO.getName());
        patient.setEmail(patientResponseDTO.getEmail());
        patient.setAddress(patientResponseDTO.getAddress());
        patient.setDateOfBirth(java.time.LocalDate.parse(patientResponseDTO.getDateOfBirth()));
        return patient;
    }
}
