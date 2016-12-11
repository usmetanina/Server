package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Course;

public class CourseLikeInDB {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseLikeInDB() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public static CourseLikeInDB fromModel(Course course) {
        if (course!=null) {
            CourseLikeInDB dto = new CourseLikeInDB();

            dto.setId((course.getId()));
            dto.setTitle(course.getTitle());
            //dto.setFaculty(course.getFaculty().getId());

            return dto;
        }
        return null;
    }
}
