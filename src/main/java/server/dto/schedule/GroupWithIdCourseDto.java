package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.cabinetAndHousing.CabinetDto;
import server.dto.cabinetAndHousing.FunctionCabinetDto;
import server.dto.cabinetAndHousing.HousingDto;
import server.entity.*;

import java.util.LinkedList;

public class GroupWithIdCourseDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("course")
    private int course;

    public GroupWithIdCourseDto() {
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

    public static GroupWithIdCourseDto fromModel(Group group) {
        if (group!=null) {
            GroupWithIdCourseDto dto = new GroupWithIdCourseDto();

            dto.setId((group.getId()));
            dto.setTitle(group.getTitle());
            dto.setCourse(group.getCourse().getId());

            return dto;
        }
        return null;
    }
}
