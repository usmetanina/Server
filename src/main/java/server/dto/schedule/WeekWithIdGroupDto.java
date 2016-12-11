package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Week;

public class WeekWithIdGroupDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private int number;

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


    public static WeekWithIdGroupDto fromModel(Week week) {
        if (week!=null) {
            WeekWithIdGroupDto dto = new WeekWithIdGroupDto();

            dto.setId((week.getId()));
            dto.setNumber(week.getNumber());

            return dto;
        }
        return null;
    }
}
