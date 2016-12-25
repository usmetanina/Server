package server.service.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.service.webServices.DatabaseService;
import server.service.webServices.UsersService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by yanta on 25.11.2016.
 */
@Service
public class EditingService {

    @Autowired
    UsersService usersService;
    @Autowired
    DatabaseService databaseService;

    public void deleteRecordById(Integer idRecord) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        databaseService.deleteEntity(usersService.tableChoice, idRecord);
        usersService.updateTableInDBMap(usersService.tableChoice);
        usersService.setEntityTableChoice();
    }

    public void saveEditedRecordById(Integer idRecord, List<String> updatedFieldsList) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Object updatedObject = usersService.currentEntityTable.getUpdatedRowObject(idRecord, updatedFieldsList);
        databaseService.saveEntity(usersService.tableChoice, updatedObject);
        usersService.updateTableInDBMap(usersService.tableChoice);
        usersService.setEntityTableChoice();
    }

    public void addNewRecord(List<String> newFieldsList) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Object newObject = usersService.currentEntityTable.addNewRowObject(newFieldsList);
        databaseService.saveEntity(usersService.tableChoice, newObject);
        //usersService.updateTableInDBMap(usersService.tableChoice);
        usersService.setInitializationState(false);
        usersService.Initialize();
        usersService.setEntityTableChoice();
    }

}
