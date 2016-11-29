package server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Cabinet;
import server.entity.FunctionCabinet;
import server.entity.StepInstruction;

public class FunctionCabinetDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("description")
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static FunctionCabinetDto fromModel(FunctionCabinet functionCabinet) {
        if (functionCabinet != null) {
            FunctionCabinetDto dto = new FunctionCabinetDto();
            dto.setId(functionCabinet.getId());
            dto.setDescription(functionCabinet.getDescription());
            return dto;
        }
        else
            return null;
    }
}

