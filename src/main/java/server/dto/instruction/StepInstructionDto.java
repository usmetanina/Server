package server.dto.instruction;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.cabinetAndHousing.CabinetWithEmployeesDto;
import server.entity.StepInstruction;

public class StepInstructionDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("serialNumber")
    private int serialNumber;

    @JsonProperty("cabinet")
    private CabinetWithEmployeesDto cabinet;

    public StepInstructionDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CabinetWithEmployeesDto getCabinet() {
        return cabinet;
    }

    public void setCabinet(CabinetWithEmployeesDto cabinet) {
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



    public static StepInstructionDto fromModel(StepInstruction stepInstruction) {
        if (stepInstruction != null) {
            StepInstructionDto dto = new StepInstructionDto();
            dto.setId(stepInstruction.getId());
            if (stepInstruction.getCabinet()!=null)
                dto.setCabinet(CabinetWithEmployeesDto.fromModel(stepInstruction.getCabinet()));
            dto.setDescription(stepInstruction.getDescription());
            dto.setSerialNumber(stepInstruction.getId());
            return dto;
        }
        else
            return null;
    }
}

