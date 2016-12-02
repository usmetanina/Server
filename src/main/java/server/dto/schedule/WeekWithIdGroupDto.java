package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.cabinetAndHousing.CabinetDto;
import server.dto.cabinetAndHousing.FunctionCabinetDto;
import server.dto.cabinetAndHousing.HousingDto;
import server.entity.*;

import java.util.LinkedList;

public class WeekWithIdGroupDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private int number;

    @JsonProperty("group")
    private int group;

    public WeekWithIdGroupDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public static WeekWithIdGroupDto fromModel(Week week) {
        if (week!=null) {
            WeekWithIdGroupDto dto = new WeekWithIdGroupDto();

            dto.setId((week.getId()));
            dto.setNumber(week.getNumber());
            dto.setGroup(week.getGroup().getId());

            return dto;
        }
        return null;
    }
}
