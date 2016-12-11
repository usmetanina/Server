package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Course;

public class CourseWithIdFacultyDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("faculty")
    private int faculty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseWithIdFacultyDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public static CourseWithIdFacultyDto fromModel(Course course) {
        if (course!=null) {
            CourseWithIdFacultyDto dto = new CourseWithIdFacultyDto();

            dto.setId((course.getId()));
            dto.setTitle(course.getTitle());
            //dto.setFaculty(course.getFaculty().getId());

            return dto;
        }
        return null;
    }
}
