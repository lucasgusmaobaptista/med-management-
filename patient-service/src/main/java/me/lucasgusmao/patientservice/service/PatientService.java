package me.lucasgusmao.patientservice.service;

import lombok.RequiredArgsConstructor;
import me.lucasgusmao.patientservice.dto.PatientRequestDTO;
import me.lucasgusmao.patientservice.dto.PatientResponseDTO;
import me.lucasgusmao.patientservice.mapper.PatientMapper;
import me.lucasgusmao.patientservice.model.Patient;
import me.lucasgusmao.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientResponseDTO create(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = patientRepository.save(PatientMapper.toEntity(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }

}
