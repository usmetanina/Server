package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.FunctionCabinet;

public interface FunctionCabinetRepository  extends JpaRepository<FunctionCabinet, Integer> {
}
