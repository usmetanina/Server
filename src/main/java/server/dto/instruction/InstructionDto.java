package server.dto.instruction;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Instruction;
import server.entity.StepInstruction;

import java.util.LinkedList;

public class InstructionDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    public InstructionDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static InstructionDto fromModel(Instruction instruction) {

        InstructionDto dto = new InstructionDto();

        dto.setId(instruction.getId());
        dto.setName(instruction.getName());

        return dto;
    }
}
