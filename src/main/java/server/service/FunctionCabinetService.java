package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.FunctionCabinet;
import server.repository.FunctionCabinetRepository;

import java.util.List;

@Service
public class FunctionCabinetService {
    @Autowired
    private FunctionCabinetRepository functionCabinetRepository;

    public List<FunctionCabinet> getAll() {
        return functionCabinetRepository.findAll();
    }

    public FunctionCabinet getByID(int id) {
        return functionCabinetRepository.findOne(id);
    }

    public FunctionCabinet save(FunctionCabinet functionCabinet) {
        return functionCabinetRepository.saveAndFlush(functionCabinet);
    }

    public void remove(int id) {functionCabinetRepository.delete(id);
    }
}
