package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Course;
import server.entity.schedule.Faculty;

import java.util.LinkedList;

public class FacultyDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("fullTitle")
    private String fullTitle;

    @JsonProperty("shortTitle")
    private String shortTitle;

    @JsonProperty("courses")
    private LinkedList<CourseDto> courses = new LinkedList<>();

    public FacultyDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public LinkedList<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(LinkedList<CourseDto> courses) {
        this.courses = courses;
    }

    public static FacultyDto fromModel(Faculty faculty) {
        if (faculty!=null) {
            FacultyDto dto = new FacultyDto();

            dto.setId((faculty.getId()));
            dto.setFullTitle(faculty.getFullTitle());
            dto.setShortTitle(faculty.getShortTitle());

            LinkedList<CourseDto> coursesDto = new LinkedList<>();

            for (Course course : faculty.getCourses()) {
                coursesDto.add(CourseDto.fromModel(course));
            }
            dto.setCourses(coursesDto);
            return dto;
        }
        return null;
    }
}
