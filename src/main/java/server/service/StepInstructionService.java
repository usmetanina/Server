package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.StepInstruction;
import server.repository.StepInstructionRepository;

import java.util.List;

@Service
public class StepInstructionService {
    @Autowired
    private StepInstructionRepository stepInstructionRepository;

    public List<StepInstruction> getAll() {
        return stepInstructionRepository.findAll();
    }

    public StepInstruction getByID(int id) {
        return stepInstructionRepository.findOne(id);
    }

    public StepInstruction save(StepInstruction stepInstruction) {
        return stepInstructionRepository.saveAndFlush(stepInstruction);
    }

    public void remove(int id) {stepInstructionRepository.delete(id);
    }
}
