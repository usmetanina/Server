package server.dto.cabinetAndHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Cabinet;
import server.entity.FunctionCabinet;

import java.util.LinkedList;

public class CabinetWithIdHousingDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("housing")
    private int housing;

    @JsonProperty("title")
    private String title;

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

    public static CabinetWithIdHousingDto fromModel(Cabinet cabinet) {
        if (cabinet!=null) {
            CabinetWithIdHousingDto dto = new CabinetWithIdHousingDto();

            dto.setId((cabinet.getId()));
            dto.setHousing(cabinet.getHousing().getId());
            dto.setNumber(cabinet.getNumber());
            dto.setTitle(cabinet.getTitle());
            dto.setLunchHours(cabinet.getLunchHours());
            dto.setWorkHours(cabinet.getWorkHours());
            return dto;
        }
        return null;
    }
}
