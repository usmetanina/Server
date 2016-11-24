package server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import server.entity.Cabinet;
import server.entity.Employee;
import server.entity.Housing;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class CabinetDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("housing")
    private HousingDto housing;

    @JsonProperty("title")
    private String title;

    @JsonProperty("functions")
    private String functions;

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

    public HousingDto getHousing() {
        return housing;
    }

    public void setHousing(HousingDto housing) {
        this.housing = housing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
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
            dto.setFunctions(cabinet.getFunctions());
            dto.setLunchHours(cabinet.getLunchHours());
            dto.setWorkHours(cabinet.getWorkHours());
            return dto;
        }
        return null;
    }
}
