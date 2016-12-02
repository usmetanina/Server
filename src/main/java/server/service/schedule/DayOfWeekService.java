package server.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.schedule.DayOfWeek;
import server.repository.schedule.DayOfWeekRepository;

import java.util.List;

@Service
public class DayOfWeekService {
    @Autowired
    DayOfWeekRepository dayOfWeekRepository;
    public List<DayOfWeek> getAll() {
        return dayOfWeekRepository.findAll();
    }

    public DayOfWeek getByID(int id) {
        return dayOfWeekRepository.findOne(id);
    }

    public DayOfWeek save(DayOfWeek day) {
        return dayOfWeekRepository.saveAndFlush(day);
    }

    public void remove(int id) {dayOfWeekRepository.delete(id);
    }
}
