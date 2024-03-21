package server.desdent.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.desdent.model.pojo.References;

import java.util.Date;
import java.util.List;

@Repository
public interface ReferencesRepository extends JpaRepository<References, Long> {

    @Query(value = "SELECT reference from References reference where reference.visitDate >= :startDate and reference.visitDate <= :endDate and reference.dentistId = :dentistId")
    List<References> findAllBySome(Date startDate, Date endDate, Long dentistId);

}
