package me.lucasgusmao.patientservice.controller;

import lombok.RequiredArgsConstructor;
import me.lucasgusmao.patientservice.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;


}
