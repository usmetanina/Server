package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.StepInstruction;

public interface StepInstructionRepository extends JpaRepository<StepInstruction,Integer>{
}
