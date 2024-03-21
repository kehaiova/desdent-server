package server.desdent.service;

import org.springframework.stereotype.Service;
import server.desdent.model.dto.sheets.RequestAmbulatorySheetsDTO;
import server.desdent.model.pojo.AmbulatorySheets;
import server.desdent.model.pojo.Dentists;
import server.desdent.model.pojo.Patients;
import server.desdent.model.repository.AmbulatorySheetsRepository;

import java.util.List;

@Service
public class AmbulatorySheetsService extends AbstractService {

    private final AmbulatorySheetsRepository ambulatorySheetsRepository;

    public AmbulatorySheetsService(AmbulatorySheetsRepository ambulatorySheetsRepository) {
        this.ambulatorySheetsRepository = ambulatorySheetsRepository;
    }

    public List<AmbulatorySheets> getAll() {
        return ambulatorySheetsRepository.findAll();
    }

    public AmbulatorySheets saveAmbulatorySheet(AmbulatorySheets requestAmbulatorySheetsDTO) {
        // Save the entity
        return ambulatorySheetsRepository.save(requestAmbulatorySheetsDTO);
    }
}
