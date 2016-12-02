package server.dto.cabinetAndHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.FunctionCabinet;

public class FunctionCabinetWithIdCabinetDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("cabinet")
    private int cabinet;

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

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public static FunctionCabinetWithIdCabinetDto fromModel(FunctionCabinet functionCabinet) {
        if (functionCabinet != null) {
            FunctionCabinetWithIdCabinetDto dto = new FunctionCabinetWithIdCabinetDto();

            dto.setId(functionCabinet.getId());
            dto.setDescription(functionCabinet.getDescription());
            dto.setCabinet(functionCabinet.getCabinet().getId());

            return dto;
        }
        else
            return null;
    }
}

