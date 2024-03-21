package server.desdent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.desdent.model.dto.sheets.RequestAmbulatorySheetsDTO;
import server.desdent.model.pojo.AmbulatorySheets;
import server.desdent.service.AmbulatorySheetsService;

import java.util.List;

@RestController
public class AmbulatorySheetsController {

    @Autowired
    private AmbulatorySheetsService ambulatorySheetsService;


    @GetMapping("/sheets/getAll")
    public List<AmbulatorySheets> getAmbulatorySheets() {
        return ambulatorySheetsService.getAll();
    }

    @PostMapping("/sheets/save")
    public AmbulatorySheets saveAmbulatorySheet(@RequestBody AmbulatorySheets ambulatorySheet) {
        return ambulatorySheetsService.saveAmbulatorySheet(ambulatorySheet);
    }
}
