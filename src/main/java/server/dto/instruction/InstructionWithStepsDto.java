package server.dto.instruction;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Instruction;
import server.entity.StepInstruction;

import java.util.LinkedList;

public class InstructionWithStepsDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("steps")
    private LinkedList<StepInstructionDto> steps = new LinkedList<>();

    public InstructionWithStepsDto() {
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

    public LinkedList<StepInstructionDto> getSteps() {
        return steps;
    }

    public void setSteps(LinkedList<StepInstructionDto> steps) {
        this.steps = steps;
    }

    public static InstructionWithStepsDto fromModel(Instruction instruction) {
        InstructionWithStepsDto dto = new InstructionWithStepsDto();
        dto.setId(instruction.getId());
        dto.setName(instruction.getName());

        LinkedList<StepInstructionDto> stepsDto = new LinkedList<>();

        for (StepInstruction step : instruction.getSteps()) {
            stepsDto.add(StepInstructionDto.fromModel(step));
        }
        dto.setSteps(stepsDto);

        return dto;
    }
}
