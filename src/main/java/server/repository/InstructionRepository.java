package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Instruction;

public interface InstructionRepository extends JpaRepository<Instruction, Integer> {
}
