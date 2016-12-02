package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.schedule.Group;
import server.entity.schedule.Week;

import java.util.LinkedList;

public class GroupDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("weeks")
    private LinkedList<WeekDto> weeks = new LinkedList<>();

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

    public LinkedList<WeekDto> getWeeks() {
        return weeks;
    }

    public void setWeeks(LinkedList<WeekDto> weeks) {
        this.weeks = weeks;
    }

    public static GroupDto fromModel(Group group) {
        if (group!=null) {
            GroupDto dto = new GroupDto();

            dto.setId((group.getId()));
            dto.setTitle(group.getTitle());

            LinkedList<WeekDto> weeksDto = new LinkedList<>();

            for (Week week : group.getWeeks()) {
                weeksDto.add(WeekDto.fromModel(week));
            }
            dto.setWeeks(weeksDto);
            return dto;
        }
        return null;
    }
}
