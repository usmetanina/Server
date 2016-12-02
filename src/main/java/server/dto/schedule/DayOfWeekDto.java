package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.DayOfWeek;
import server.entity.schedule.Lesson;

import java.util.LinkedList;

public class DayOfWeekDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("dayOfWeek")
    private String dayOfWeek;

    @JsonProperty("numberOfDayOfWeek")
    private int numberOfDayOfWeek;

    @JsonProperty("lessons")
    private LinkedList<LessonDto> lessons = new LinkedList<>();

    public DayOfWeekDto() {
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

    public LinkedList<LessonDto> getLessons() {
        return lessons;
    }

    public void setLessons(LinkedList<LessonDto> lessons) {
        this.lessons = lessons;
    }

    public static DayOfWeekDto fromModel(DayOfWeek dayOfWeek) {
        if (dayOfWeek!=null) {
            DayOfWeekDto dto = new DayOfWeekDto();

            dto.setId((dayOfWeek.getId()));
            dto.setDayOfWeek(dayOfWeek.getDayOfWeek());
            dto.setNumberOfDayOfWeek(dayOfWeek.getNumberOfDayOfWeek());

            LinkedList<LessonDto> lessonsDto = new LinkedList<>();

            for (Lesson lesson : dayOfWeek.getLessons()) {
                lessonsDto.add(LessonDto.fromModel(lesson));
            }
            dto.setLessons(lessonsDto);
            return dto;
        }
        return null;
    }
}
