package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Group;
import server.entity.schedule.Lesson;
import server.entity.schedule.Week;

import java.util.LinkedList;

public class GroupDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("lessons")
    private LinkedList<LessonDto> lessons = new LinkedList<>();

    public GroupDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<LessonDto> getLessons() {
        return lessons;
    }

    public void setLessons(LinkedList<LessonDto> lessons) {
        this.lessons = lessons;
    }

    public static GroupDto fromModel(Group group) {
        if (group!=null) {
            GroupDto dto = new GroupDto();

            dto.setId((group.getId()));
            dto.setTitle(group.getTitle());

            LinkedList<LessonDto> lessonDtos = new LinkedList<>();

            for (Lesson lesson : group.getLessons()) {
                lessonDtos.add(LessonDto.fromModel(lesson));
            }
            dto.setLessons(lessonDtos);

            return dto;
        }
        return null;
    }
}
