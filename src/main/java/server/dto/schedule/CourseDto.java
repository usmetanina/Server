package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Course;
import server.entity.schedule.Faculty;
import server.entity.schedule.Group;

import java.util.LinkedList;

public class CourseDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("groups")
    private LinkedList<GroupDto> groups = new LinkedList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<GroupDto> getGroups() {
        return groups;
    }

    public void setGroups(LinkedList<GroupDto> groups) {
        this.groups = groups;
    }

    public static CourseDto fromModel(Course course) {
        if (course!=null) {
            CourseDto dto = new CourseDto();
            dto.setId((course.getId()));
            dto.setTitle(course.getTitle());

            LinkedList<GroupDto> groupsDto = new LinkedList<>();

            for (Group group : course.getGroups()) {
                groupsDto.add(GroupDto.fromModel(group));
            }
            dto.setGroups(groupsDto);

            return dto;
        }
        return null;
    }
}
