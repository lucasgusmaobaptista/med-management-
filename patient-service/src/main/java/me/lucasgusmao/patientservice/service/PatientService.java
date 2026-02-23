package me.lucasgusmao.patientservice.service;

import lombok.RequiredArgsConstructor;
import me.lucasgusmao.patientservice.dto.PatientRequestDTO;
import me.lucasgusmao.patientservice.dto.PatientResponseDTO;
import me.lucasgusmao.patientservice.exception.EmailAlreadyExistsException;
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

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Já existe um paciente com o email: " + patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toEntity(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }

}
