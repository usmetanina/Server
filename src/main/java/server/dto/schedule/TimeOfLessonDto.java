package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.TimeOfLesson;

public class TimeOfLessonDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("numberOfLesson")
    private int numberOfLesson;

    @JsonProperty("timeBegin")
    private String timeBegin;

    @JsonProperty("timeEnd")
    private String timeEnd;

    public TimeOfLessonDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public static TimeOfLessonDto fromModel(TimeOfLesson timeOfLesson) {
        if (timeOfLesson!=null) {
            TimeOfLessonDto dto = new TimeOfLessonDto();

            dto.setId((timeOfLesson.getId()));
            dto.setNumberOfLesson(timeOfLesson.getNumberOfLesson());
            dto.setTimeBegin(timeOfLesson.getTimeBegin());
            dto.setTimeEnd(timeOfLesson.getTimeEnd());

            return dto;
        }
        return null;
    }
}
