package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.Instruction;
import server.repository.InstructionRepository;

import java.util.List;

@Service
public class InstructionService {

    @Autowired
    private InstructionRepository instructionRepository;

    public List<Instruction> getAll() {
        return instructionRepository.findAll();
    }

    public Instruction getByID(int id) {
        return instructionRepository.findOne(id);
    }

    public Instruction save(Instruction instruction) {
        return instructionRepository.saveAndFlush(instruction);
    }

    public void remove(int id) {
        instructionRepository.delete(id);
    }
}
