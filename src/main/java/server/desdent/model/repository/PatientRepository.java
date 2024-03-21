package server.desdent.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.desdent.model.pojo.Patients;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {

    Optional<Patients> findByPatientIdentifier(String patientIdentifier);
}
