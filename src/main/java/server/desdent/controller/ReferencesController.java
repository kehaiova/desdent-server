package server.desdent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import server.desdent.model.pojo.References;
import server.desdent.service.ReferencesService;

import java.util.Date;
import java.util.List;

@RestController
public class ReferencesController {

    @Autowired
    private ReferencesService service;

    @GetMapping("/references/{startDate}/{endDate}/{dentistId}")
    public List<References> getReferences(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                          @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                                          @PathVariable Long dentistId) {
        return service.getReferences(startDate, endDate, dentistId);

    }
}
