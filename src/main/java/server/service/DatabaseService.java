package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.*;
import server.repository.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanta on 28.11.2016.
 */
@Service
public class DatabaseService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired
    FunctionCabinetRepository functionCabinetRepository;
    @Autowired
    HousingRepository housingRepository;
    @Autowired
    InstructionRepository instructionRepository;
    @Autowired
    StepInstructionRepository stepInstructionRepository;

    private Map< String, Object > EntityRepositoryMap;
    private Map< String, Object > EntityMap;


    public void initializeEntityMap() {
        EntityRepositoryMap = new HashMap< String, Object >();
        EntityRepositoryMap.put("Пользователи/Администраторы", userRepository);
        EntityRepositoryMap.put("Корпуса", housingRepository);
        EntityRepositoryMap.put("Кабинеты", cabinetRepository);
        EntityRepositoryMap.put("Описание кабинетов", functionCabinetRepository);
        EntityRepositoryMap.put("Компоненты справочника", stepInstructionRepository);
        EntityRepositoryMap.put("Справочник", instructionRepository);
        EntityRepositoryMap.put("Сотрудники", employeeRepository);

        EntityMap = new HashMap< String, Object >();
        EntityMap.put("Пользователи/Администраторы", new User());
        EntityMap.put("Корпуса", new Housing());
        EntityMap.put("Кабинеты", new Cabinet());
        EntityMap.put("Описание кабинетов", new FunctionCabinet());
        EntityMap.put("Компоненты справочника", new StepInstruction());
        EntityMap.put("Справочник", new Instruction());
        EntityMap.put("Сотрудники", new Employee());
    }

    public List getEntityList(String tableName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List entityList = null;
        Object tmpObject = EntityRepositoryMap.get(tableName);
        Method objectMethod = tmpObject.getClass().getMethod("findAll"); // get method
        entityList = (List) objectMethod.invoke(tmpObject); // execute method
        entityList.add(EntityMap.get(tableName)); // empty entity for addition
        return entityList;
    }

    public void saveEntity(String tableName, Object objectEntity) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object tmpObject = EntityRepositoryMap.get(tableName);
        Method objectMethod = tmpObject.getClass().getMethod("saveAndFlush", Object.class); // get method
        objectMethod.invoke(tmpObject, objectEntity); // execute method
    }

    public void deleteEntity(String tableName, Integer idEntity) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object tmpObject = EntityRepositoryMap.get(tableName);
        Method objectMethod;
        Method methods[] = tmpObject.getClass().getMethods();
        if (tableName.equals("Пользователи/Администраторы")) {
            Serializable reqId = idEntity;
            objectMethod = tmpObject.getClass().getMethod("delete", Serializable.class); // get method
            objectMethod.invoke(tmpObject, reqId); // execute method
        } else {
            int id = idEntity;
            switch(tableName) {
                case "Корпуса":
                    housingRepository.delete(id);
                    break;
                case "Кабинеты":
                    cabinetRepository.delete(id);
                    break;
                case "Описание кабинетов":
                    functionCabinetRepository.delete(id);
                    break;
                case "Компоненты справочника":
                    stepInstructionRepository.delete(id);
                    break;
                case "Справочник":
                    instructionRepository.delete(id);
                    break;
                case "Сотрудники":
                    employeeRepository.delete(id);
                    break;
                default:
                    break;
            }
        }
    }

    private Object findEntityById(String tableName, Integer id) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        List entityList = null;
        Object repositoryObject = EntityRepositoryMap.get(tableName);
        Method objectMethod = repositoryObject.getClass().getMethod("findAll"); // get method
        entityList = (List) objectMethod.invoke(repositoryObject); // execute method

        for (int i = 0; i < entityList.size(); i++) {
            Object entityObject = entityList.get(i);
            Field[] fields = entityObject.getClass().getDeclaredFields(); // fields of this class
            fields[0].setAccessible(true);
            if (fields[0].getInt(entityObject) == id) {
                return entityObject;
            }
        }
        return null;
    }

}
