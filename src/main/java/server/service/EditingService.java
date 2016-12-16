package server.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import server.entity.*;
import server.repository.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by yanta on 25.11.2016.
 */
@Service
public class EditingService {

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

    public void deleteRecordById(long longIdRecord, int shortIdRecord, String tableChoice) {
        switch(tableChoice) {
            case "Пользователи/Администраторы":
                userRepository.delete(longIdRecord);
                break;
            case "Корпуса":
                housingRepository.delete(shortIdRecord);
                break;
            case "Кабинеты":
                cabinetRepository.delete(shortIdRecord);
                break;
            case "Описание кабинетов":
                functionCabinetRepository.delete(shortIdRecord);
                break;
            case "Компоненты справочника":
                stepInstructionRepository.delete(shortIdRecord);
                break;
            case "Справочник":
                instructionRepository.delete(shortIdRecord);
                break;
            case "Сотрудники":
                employeeRepository.delete(shortIdRecord);
                break;
            default:
                break;
        }
    }

    public void saveChangesForRecord(Object updatedObject, String tableChoice) {
        String nameofClass = updatedObject.getClass().getName();
        switch(tableChoice) {
            case "Пользователи/Администраторы":
                User updatedUser = (User)updatedObject;
                userRepository.saveAndFlush(updatedUser);
                break;
            case "Корпуса":
                Housing updatedHousing = (Housing)updatedObject;
                housingRepository.saveAndFlush(updatedHousing);
                break;
            case "Кабинеты":
                Cabinet updatedCabinet = (Cabinet)updatedObject;
                cabinetRepository.saveAndFlush(updatedCabinet);
                break;
            case "Описание кабинетов":
                FunctionCabinet updatedFunctionCabinet = (FunctionCabinet)updatedObject;
                functionCabinetRepository.saveAndFlush(updatedFunctionCabinet);
                break;
            case "Компоненты справочника":
                StepInstruction updatedStepInstruction = (StepInstruction)updatedObject;
                stepInstructionRepository.saveAndFlush(updatedStepInstruction);
                break;
            case "Справочник":
                Instruction updatedInstruction = (Instruction)updatedObject;
                instructionRepository.saveAndFlush(updatedInstruction);
                break;
            case "Сотрудники":
                Employee updatedEmployee = (Employee)updatedObject;
                employeeRepository.saveAndFlush(updatedEmployee);
                break;
            default:
                break;
        }
    }

    public interface Edition<T> {

        //void saveChangesForRecord(T Object);
        T editPickedRecord(T Object, List updatedFields) throws IllegalAccessException;
    }

    public static class EditToolsClass implements Edition {

        @Override
        public Object editPickedRecord(Object ObjectForUpdate, List updatedFieldsList) throws IllegalAccessException {

            Object valueOfField;
            int intValue;
            Class fieldType;
            int k = 0; // counter of amount of fields

            if (ObjectForUpdate != null) {
                Field[] fields = ObjectForUpdate.getClass().getDeclaredFields(); // fields of this class
                Integer amountOfColumns = updatedFieldsList.size();

                for (Field field : fields) { // loop for fields in object
                    if (k < amountOfColumns) { // check of amount of fields

                        field.setAccessible(true); // this part allows to get access to private fields
                        valueOfField = updatedFieldsList.get(k);
                        fieldType = field.getType();

                        if (valueOfField != null && valueOfField != "/* не заполнено */") {
                            if (fieldType.getName() == "int") {
                                intValue = Integer.parseInt(valueOfField.toString());
                                field.setInt(ObjectForUpdate, intValue);
                            } else {
                                field.set(ObjectForUpdate, valueOfField); // get value of field in object
                            }
                        }

                    } // if
                    k++;
                } // for
            }

            return ObjectForUpdate;
        }
    }

}
