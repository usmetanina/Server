package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Lesson;

public class LessonWithAllIdDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("typeOfLesson")
    private String typeOfLesson;

    @JsonProperty("nameOfSubject")
    private String nameOfSubject;

    @JsonProperty("subgroup")
    private Integer subgroup;

    @JsonProperty("employee")
    private int employee;

    @JsonProperty("cabinet")
    private int cabinet;

    @JsonProperty("time")
    private int time;

    @JsonProperty("dayOfWeek")
    private int dayOfWeek;

    @JsonProperty("studentGroup")
    private int studentGroup;

    @JsonProperty("week")
    private int week;

    public LessonWithAllIdDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(int studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getTypeOfLesson() {
        return typeOfLesson;
    }

    public Integer getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public static LessonWithAllIdDto fromModel(Lesson lesson) {
        if (lesson!=null) {
            LessonWithAllIdDto dto = new LessonWithAllIdDto();

            dto.setId((lesson.getId()));
            dto.setCabinet(lesson.getCabinet().getId());
            dto.setEmployee(lesson.getEmployee().getId());
            dto.setNameOfSubject(lesson.getNameOfSubject());
            dto.setTime(lesson.getTime().getId());
            dto.setTypeOfLesson(lesson.getTypeOfLesson());
            dto.setSubgroup(lesson.getSubgroup());
            dto.setDayOfWeek(lesson.getDayOfWeek().getId());
            dto.setWeek(lesson.getWeek().getId());
            dto.setStudentGroup(lesson.getGroup().getId());
            return dto;
        }
        return null;
    }
}
