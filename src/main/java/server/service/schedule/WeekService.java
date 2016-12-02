package server.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.schedule.Week;
import server.repository.schedule.WeekRepository;

import java.util.List;

@Service
public class WeekService {
    @Autowired
    private WeekRepository weekRepository;

    public List<Week> getAll() {
        return weekRepository.findAll();
    }

    public Week getByID(int id) {
        return weekRepository.findOne(id);
    }

    public Week save(Week week) {
        return weekRepository.saveAndFlush(week);
    }

    public void remove(int id) {weekRepository.delete(id);
    }
}
