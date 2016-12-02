package server.dto.instruction;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.cabinetAndHousing.CabinetWithEmployeesDto;
import server.entity.StepInstruction;

public class StepInstructionWithAllIdDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("serialNumber")
    private int serialNumber;

    @JsonProperty("cabinet")
    private int cabinet;

    @JsonProperty("instruction")
    private int instruction;

    public StepInstructionWithAllIdDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstruction() {
        return instruction;
    }

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }



    public static StepInstructionWithAllIdDto fromModel(StepInstruction stepInstruction) {
        if (stepInstruction != null) {

            StepInstructionWithAllIdDto dto = new StepInstructionWithAllIdDto();
            dto.setId(stepInstruction.getId());
            if (stepInstruction.getCabinet()!=null)
                dto.setCabinet(stepInstruction.getCabinet().getId());
            dto.setDescription(stepInstruction.getDescription());
            dto.setSerialNumber(stepInstruction.getId());
            dto.setInstruction(stepInstruction.getInstruction().getId());
            return dto;
        }
        else
            return null;
    }
}

