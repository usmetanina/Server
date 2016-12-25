package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Group;

public class GroupWithAllIdDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("course")
    private int course;

    @JsonProperty("faculty")
    private int faculty;

    public GroupWithAllIdDto() {
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public static GroupWithAllIdDto fromModel(Group group) {
        if (group!=null) {
            GroupWithAllIdDto dto = new GroupWithAllIdDto();

            dto.setId((group.getId()));
            dto.setTitle(group.getTitle());
            dto.setCourse(group.getCourse().getId());
            dto.setFaculty(group.getFaculty().getId());

            return dto;
        }
        return null;
    }
}
