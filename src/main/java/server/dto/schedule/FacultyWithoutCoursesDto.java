package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Faculty;

public class FacultyWithoutCoursesDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("fullTitle")
    private String fullTitle;

    @JsonProperty("shortTitle")
    private String shortTitle;

    public FacultyWithoutCoursesDto() {
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

    public static FacultyWithoutCoursesDto fromModel(Faculty faculty) {
        if (faculty!=null) {
            FacultyWithoutCoursesDto dto = new FacultyWithoutCoursesDto();

            dto.setId((faculty.getId()));
            dto.setFullTitle(faculty.getFullTitle());
            dto.setShortTitle(faculty.getShortTitle());

            return dto;
        }
        return null;
    }
}
