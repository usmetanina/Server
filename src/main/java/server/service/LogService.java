package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.Log;
import server.repository.LogRepository;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public List<Log> getAll() {
        return logRepository.findAll();
    }

    public Log getByID(int id) {
        return logRepository.findOne(id);
    }

    public Log save(Log log) {
        return logRepository.saveAndFlush(log);
    }

    public void remove(int id) {logRepository.delete(id);
    }
}
