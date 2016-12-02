package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.cabinetAndHousing.CabinetDto;
import server.dto.cabinetAndHousing.FunctionCabinetDto;
import server.dto.cabinetAndHousing.HousingDto;
import server.entity.*;

import java.util.LinkedList;

public class DayOfWeekWithIdWeekDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("dayOfWeek")
    private String dayOfWeek;

    @JsonProperty("numberOfDayOfWeek")
    private int numberOfDayOfWeek;

    @JsonProperty("week")
    private int week;

    public DayOfWeekWithIdWeekDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getNumberOfDayOfWeek() {
        return numberOfDayOfWeek;
    }

    public void setNumberOfDayOfWeek(int numberOfDayOfWeek) {
        this.numberOfDayOfWeek = numberOfDayOfWeek;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public static DayOfWeekWithIdWeekDto fromModel(DayOfWeek dayOfWeek) {
        if (dayOfWeek!=null) {
            DayOfWeekWithIdWeekDto dto = new DayOfWeekWithIdWeekDto();

            dto.setId((dayOfWeek.getId()));
            dto.setDayOfWeek(dayOfWeek.getDayOfWeek());
            dto.setNumberOfDayOfWeek(dayOfWeek.getNumberOfDayOfWeek());
            dto.setWeek(dayOfWeek.getWeek().getId());

            return dto;
        }
        return null;
    }
}
