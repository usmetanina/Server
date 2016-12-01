package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.cabinetAndHousing.CabinetDto;
import server.dto.cabinetAndHousing.FunctionCabinetDto;
import server.dto.cabinetAndHousing.HousingDto;
import server.entity.*;

import java.util.LinkedList;

public class WeekDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private int number;

    @JsonProperty("days")
    private LinkedList<DayOfWeekDto> days = new LinkedList<>();

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

    public LinkedList<DayOfWeekDto> getDays() {
        return days;
    }

    public void setDays(LinkedList<DayOfWeekDto> days) {
        this.days = days;
    }

    public static WeekDto fromModel(Week week) {
        if (week!=null) {
            WeekDto dto = new WeekDto();

            dto.setId((week.getId()));
            dto.setNumber(week.getNumber());

            LinkedList<DayOfWeekDto> daysDto = new LinkedList<>();

            for (DayOfWeek dayOfWeek : week.getDays()) {
                daysDto.add(DayOfWeekDto.fromModel(dayOfWeek));
            }
            dto.setDays(daysDto);
            return dto;
        }
        return null;
    }
}
