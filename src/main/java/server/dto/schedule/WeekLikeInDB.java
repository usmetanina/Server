package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Week;

public class WeekLikeInDB {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private int number;

    public WeekLikeInDB() {
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


    public static WeekLikeInDB fromModel(Week week) {
        if (week!=null) {
            WeekLikeInDB dto = new WeekLikeInDB();

            dto.setId((week.getId()));
            dto.setNumber(week.getNumber());

            return dto;
        }
        return null;
    }
}
