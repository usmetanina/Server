package server.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.schedule.Group;
import server.repository.schedule.GroupRepository;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    public Group getByID(int id) {
        return groupRepository.findOne(id);
    }

    public Group save(Group group) {
        return groupRepository.saveAndFlush(group);
    }

    public void remove(int id) {groupRepository.delete(id);
    }
}
