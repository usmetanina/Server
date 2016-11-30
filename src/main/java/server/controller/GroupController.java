package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.entity.Group;
import server.service.GroupService;
import java.util.List;

@RestController
@RequestMapping("/")
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/groups" , method = RequestMethod.GET)
    @ResponseBody
    public List<Group> getAllGroups() {
        /*List<Employee> list = employeeService.getAll();
        List<EmployeeWithCabinetDto> result = new ArrayList<>(list.size());
        list.forEach(employee -> result.add(EmployeeWithCabinetDto.fromModel(employee)));*/
        return groupService.getAll();
    }

    @RequestMapping(value = "/schedule/{group}" , method = RequestMethod.GET)
    @ResponseBody
    public Group getGroup(@PathVariable int group) {
        /*Employee employee = employeeService.getByID(id);
        return EmployeeWithCabinetDto.fromModel(employee);*/
        return groupService.getByID(group);
    }

}
