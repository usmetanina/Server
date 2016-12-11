package server.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.GroupDto;
import server.dto.schedule.GroupWithAllIdDto;
import server.entity.schedule.Group;
import server.service.schedule.GroupService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/groups" , method = RequestMethod.GET)
    @ResponseBody
    public List<GroupDto> getAllGroups() {
        List<Group> list = groupService.getAll();
        List<GroupDto> result = new ArrayList<>(list.size());
        list.forEach(group -> result.add(GroupDto.fromModel(group)));
        return result;
    }

    @RequestMapping(value = "/groupEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<GroupWithAllIdDto> getAllGroupsWithIdCourse() {
        List<Group> list = groupService.getAll();
        List<GroupWithAllIdDto> result = new ArrayList<>(list.size());
        list.forEach(group -> result.add(GroupWithAllIdDto.fromModel(group)));
        return result;
    }

    @RequestMapping(value = "/schedule/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public GroupDto getGroup(@PathVariable int id) {
        Group group = groupService.getByID(id);
        return GroupDto.fromModel(group);
    }

}
