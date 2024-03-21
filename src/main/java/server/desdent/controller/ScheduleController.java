package server.desdent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import server.desdent.model.pojo.Schedule;
import server.desdent.service.ScheduleService;

import java.util.Date;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping("/schedule/{dentistId}/{visitDate}")
    public List<Schedule> getDentistSchedule(@PathVariable Long dentistId,
                                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date visitDate) {
        return service.getDentistSchedule(dentistId, visitDate);
    }

}
