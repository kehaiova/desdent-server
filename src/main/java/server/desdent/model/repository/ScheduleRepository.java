package server.desdent.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.desdent.model.pojo.Schedule;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value="SELECT s FROM Schedule s JOIN FETCH s.dentist d where d.id=:dentistId AND s.visitDate=:date")
    List<Schedule> findSchedulesByDentistAndVisitDate(Long dentistId, Date date);
}
