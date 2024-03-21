package server.desdent.service;

import org.springframework.stereotype.Service;
import server.desdent.model.dto.schedule.RequestScheduleDTO;
import server.desdent.model.pojo.Schedule;
import server.desdent.model.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService extends AbstractService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getDentistSchedule(Long dentistId, Date date) {
        List<Schedule> schedules = scheduleRepository.findSchedulesByDentistAndVisitDate(dentistId, date);
        List<RequestScheduleDTO> scheduleDTOS = new ArrayList<>();
        schedules.forEach(schedule -> scheduleDTOS.add(modelMapper.map(schedule, RequestScheduleDTO.class)));
        return schedules;
    }
}
