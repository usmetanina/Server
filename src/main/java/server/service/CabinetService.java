package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.Cabinet;
import server.repository.CabinetRepository;

import java.util.List;

@Service
public class CabinetService {

    @Autowired
    private CabinetRepository cabinetRepository;

    public List<Cabinet> getAll() {
        return cabinetRepository.findAll();
    }

    public Cabinet getByID(int id) {
        return cabinetRepository.findOne(id);
    }

    public Cabinet save(Cabinet cabinet) {
        return cabinetRepository.saveAndFlush(cabinet);
    }

    public void remove(int id) {
        cabinetRepository.delete(id);
    }
}
