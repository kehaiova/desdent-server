package server.desdent.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import server.desdent.model.pojo.Patients;
import server.desdent.model.repository.PatientRepository;

import java.util.Optional;

@Service
public class PatientsService extends AbstractService {

    private final PatientRepository patientRepository;

    public PatientsService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<Patients> findByPersonIdentifier(String personIdentifier) {
        if (patientRepository.findByPatientIdentifier(personIdentifier).isPresent()) {
            return patientRepository.findByPatientIdentifier(personIdentifier);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person doesn't exist!");
        }
    }

}
