package server.desdent.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.desdent.model.pojo.AmbulatorySheets;

@Repository
public interface AmbulatorySheetsRepository extends JpaRepository<AmbulatorySheets, Long> {


}
