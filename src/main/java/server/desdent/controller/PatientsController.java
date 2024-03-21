package server.desdent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import server.desdent.model.pojo.Patients;
import server.desdent.service.PatientsService;

import java.util.Optional;

@RestController
public class PatientsController {

    @Autowired
    private PatientsService service;

    @GetMapping("/patients/{patientIdentifier}")
    public Optional<Patients> findByPatientIdentifier(@PathVariable String patientIdentifier) {
        return service.findByPersonIdentifier(patientIdentifier);
    }
}
