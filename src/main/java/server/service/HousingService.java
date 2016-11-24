package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.Housing;
import server.repository.HousingRepository;

import java.util.List;

@Service
public class HousingService {

    @Autowired
    private HousingRepository housingRepository;

    public List<Housing> getAll() {
        return housingRepository.findAll();
    }

    public Housing getByID(int id) {
        return housingRepository.findOne(id);
    }

    public Housing save(Housing housing) {
        return housingRepository.saveAndFlush(housing);
    }

    public void remove(int id) {
        housingRepository.delete(id);
    }
}