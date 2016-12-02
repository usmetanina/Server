package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.GroupDto;
import server.dto.schedule.GroupWithIdCourseDto;
import server.entity.Group;
import server.service.GroupService;

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
    public List<GroupWithIdCourseDto> getAllGroupsWithIdCourse() {
        List<Group> list = groupService.getAll();
        List<GroupWithIdCourseDto> result = new ArrayList<>(list.size());
        list.forEach(group -> result.add(GroupWithIdCourseDto.fromModel(group)));
        return result;
    }

    @RequestMapping(value = "/schedule/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public GroupDto getGroup(@PathVariable int id) {
        Group group = groupService.getByID(id);
        return GroupDto.fromModel(group);
    }

}
