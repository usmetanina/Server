package server.dto.cabinetAndHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Cabinet;
import server.entity.FunctionCabinet;

import java.util.LinkedList;

public class CabinetWithIdHousing {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("housing")
    private int housing;

    @JsonProperty("title")
    private String title;

    @JsonProperty("functions")
    private LinkedList<FunctionCabinetDto> functions = new LinkedList<>();

    @JsonProperty("workHours")
    private String workHours;

    @JsonProperty("lunchHours")
    private String lunchHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getHousing() {
        return housing;
    }

    public void setHousing(int housing) {
        this.housing = housing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<FunctionCabinetDto> getFunctions() {
        return functions;
    }

    public void setFunctions(LinkedList<FunctionCabinetDto> functions) {
        this.functions = functions;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    public static CabinetDto fromModel(Cabinet cabinet) {
        if (cabinet!=null) {
            CabinetDto dto = new CabinetDto();
            dto.setId((cabinet.getId()));
            dto.setHousing(HousingDto.fromModel(cabinet.getHousing()));
            dto.setNumber(cabinet.getNumber());
            dto.setTitle(cabinet.getTitle());

            LinkedList<FunctionCabinetDto> functonsDto = new LinkedList<>();

            for (FunctionCabinet functionCabinet : cabinet.getFunctions()) {
                functonsDto.add(FunctionCabinetDto.fromModel(functionCabinet));
            }
            dto.setFunctions(functonsDto);

            dto.setLunchHours(cabinet.getLunchHours());
            dto.setWorkHours(cabinet.getWorkHours());
            return dto;
        }
        return null;
    }
}
