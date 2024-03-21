package server.desdent.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import server.desdent.model.repository.AmbulatorySheetsRepository;
import server.desdent.model.repository.DentistsRepository;
import server.desdent.model.repository.PatientRepository;
import server.desdent.model.repository.ReferencesRepository;

public abstract class AbstractService {
    @Autowired
    protected DentistsRepository dentistsRepository;

    @Autowired
    protected ReferencesRepository referencesRepository;

    @Autowired
    protected PatientRepository patientRepository;

    @Autowired
    protected AmbulatorySheetsRepository ambulatorySheetsRepository;

    @Autowired
    protected EmailService emailService;

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;
}
