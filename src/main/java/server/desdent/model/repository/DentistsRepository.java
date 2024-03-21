package server.desdent.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.desdent.model.pojo.Dentists;
import server.desdent.model.pojo.Schedule;

import java.util.Optional;

@Repository
public interface DentistsRepository extends JpaRepository<Dentists, Long> {

    Dentists findByUsername(String username);

    Dentists findByEmail(String email);

    Optional<Dentists> findByPhoneNumContaining (String mobilePhone);

}
