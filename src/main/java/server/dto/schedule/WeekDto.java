package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.DayOfWeek;
import server.entity.schedule.Week;

import java.util.LinkedList;

public class WeekDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private int number;

    public WeekDto() {
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

    public static WeekDto fromModel(Week week) {
        if (week!=null) {
            WeekDto dto = new WeekDto();

            dto.setId((week.getId()));
            dto.setNumber(week.getNumber());

            return dto;
        }
        return null;
    }
}
