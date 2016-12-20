package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.*;
import server.repository.*;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by yanta on 23.11.2016.
 */

@Service
public class UsersService {

    boolean Initialization = false;

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
    @Autowired
    DatabaseService databaseService;

    public Map<String, List> dataBaseMap = new HashMap<String, List>(); // for whole database
    public Map<String, EntityTable> DBMap = new HashMap<String, EntityTable>(); // for whole database

    public String currentUser;
    public boolean unsuccessfulAuthorisation = false;

    public int pickedRecord = 0;
    public String tableChoice = null;
    public EntityTable currentEntityTable = new EntityTable();

    public Map<Integer, List> tableDataMap = new HashMap<Integer, List>(); // for the certain table
    public List<Integer> detectedRecords;

    Map< String, List<String> > ColumnNamesForTable = new HashMap< String, List<String> >();

    public List<String> ListOfColumnNamesForTable = new ArrayList<String>();
    List<String> ListUserColumnNames = Arrays.asList("ID", "Логин");
    List<String> ListHousingColumnNames = Arrays.asList("ID", "Номер", "Название", "Город", "Улица", "Дом");
    List<String> ListCabinetColumnNames = Arrays.asList("ID", "Номер", "Корпус", "Название", "Часы работы", "Обеденный перерыв");
    List<String> ListFunctionCabinetColumnNames = Arrays.asList("ID", "Описание", "Номер кабинета");
    List<String> ListEmployeeColumnNames = Arrays.asList("ID", "Имя", "Отчество", "Фамилия", "Должность", "Телефон", "Email", "Кабинет");
    List<String> ListInstructionColumnNames = Arrays.asList("ID", "Название");
    List<String> ListStepInstructionColumnNames = Arrays.asList("ID", "Описание компонента", "Номер", "Название инструкции", "Номер кабинета");

    List<String> TablesNames = new ArrayList<String>();

    public void setInitializationState (boolean newInitialization) {
        Initialization = newInitialization;
    }

    void setColumnsNames() {
        ColumnNamesForTable.put("Пользователи/Администраторы", ListUserColumnNames);
        ColumnNamesForTable.put("Корпуса", ListHousingColumnNames);
        ColumnNamesForTable.put("Кабинеты", ListCabinetColumnNames);
        ColumnNamesForTable.put("Описание кабинетов", ListFunctionCabinetColumnNames);
        ColumnNamesForTable.put("Компоненты справочника", ListStepInstructionColumnNames);
        ColumnNamesForTable.put("Справочник", ListInstructionColumnNames);
        ColumnNamesForTable.put("Сотрудники", ListEmployeeColumnNames);
    }

    void setTablesNames() {
        TablesNames.add("Пользователи/Администраторы");
        TablesNames.add("Корпуса");
        TablesNames.add("Кабинеты");
        TablesNames.add("Описание кабинетов");
        TablesNames.add("Компоненты справочника");
        TablesNames.add("Справочник");
        TablesNames.add("Сотрудники");
    }

    public List<String> getColumnsNames(String tableName) {
        return ColumnNamesForTable.get(tableName);
    }

    void setDataBaseMap() {

        List listTmp = userRepository.findAll();
        listTmp.add(new User());
        dataBaseMap.put("Пользователи/Администраторы", listTmp);

        listTmp = housingRepository.findAll();
        listTmp.add(new Housing());
        dataBaseMap.put("Корпуса", listTmp);

        listTmp = cabinetRepository.findAll();
        listTmp.add(new Cabinet());
        dataBaseMap.put("Кабинеты", listTmp);

        listTmp = functionCabinetRepository.findAll();
        listTmp.add(new FunctionCabinet());
        dataBaseMap.put("Описание кабинетов", listTmp);

        listTmp = stepInstructionRepository.findAll();
        listTmp.add(new StepInstruction());
        dataBaseMap.put("Компоненты справочника", listTmp);

        listTmp = instructionRepository.findAll();
        listTmp.add(new Instruction());
        dataBaseMap.put("Справочник", listTmp);

        listTmp = employeeRepository.findAll();
        listTmp.add(new Employee());
        dataBaseMap.put("Сотрудники", listTmp);

        Initialization = true;
    }

    public List getListOfTableObjects(String tableName) {
        return dataBaseMap.get(tableName);
    }

    public void setDBMap() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        for (int i=0; i < TablesNames.size(); i++) {
            DBMap.put(TablesNames.get(i), new EntityTable(
                    TablesNames.get(i),
                    ColumnNamesForTable.get(TablesNames.get(i)),
                    databaseService.getEntityList(TablesNames.get(i)),
                    getReadableForeignKeyFieldsMap(TablesNames.get(i))) );
        }
    }

    public void updateTableInDBMap(String TableName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DBMap.replace(
                TableName,
                new EntityTable(TableName,
                ColumnNamesForTable.get(TableName),
                databaseService.getEntityList(TableName),
                getReadableForeignKeyFieldsMap(TableName) )
                    );
    }

    public void Initialize() throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException {
        if (!Initialization) {
            setColumnsNames();
            setDataBaseMap();
            setTablesNames();
            databaseService.initializeEntityMap();
            setDBMap();

            Initialization = true;
        }
    }

    public void setEntityTableChoice() {
        this.currentEntityTable = DBMap.get(this.tableChoice);
    }

    public Map<Integer, List> getTableData(String className) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        if (Initialization == false) {
            setColumnsNames();
            setDataBaseMap();
            setTablesNames();
        }

        List listOfObjects = getListOfTableObjects(className);
        ListOfColumnNamesForTable = getColumnsNames(className);
        int sizeOfListOfObject = listOfObjects.size();

        tableDataMap = new HashMap<Integer, List>();

        List<String> rowDataList;
        int k = 0; // counter of amount of fields
        Integer amountOfColumns = getColumnsNames(className).size();
        Object valueOfField;
        String strValue;
        String typeNameOfField;

        for (int i=0; i < sizeOfListOfObject; i++) { // loop for objects in list

            Object tmpObject = listOfObjects.get(i); // object of class, that user chose before
            Field[] fields = tmpObject.getClass().getDeclaredFields(); // fields of this class
            rowDataList = new ArrayList<String>();

            for (Field field : fields) { // loop for fields in object
                if (k < amountOfColumns) { // check of amount of fields

                    field.setAccessible(true); // this part allows to get access to private fields
                    valueOfField = field.get(tmpObject); // get value of field in object
                    //typeNameOfField = field.getType().;

                    if (valueOfField != null) {
                        strValue = valueOfField.toString();

                        if ( strValue.contains("@") ) {
                            strValue = strValue.substring( 0, strValue.indexOf('@') );
                            strValue = getReadableForeignKeyFields(tmpObject).get(strValue);
                            rowDataList.add(strValue);
                        } else {
                            rowDataList.add(valueOfField.toString()); // add value of field in list for row
                        }
                    }
                    else {
                        rowDataList.add("/* не заполнено */");
                    }


                }
                k++;
            }
            tableDataMap.put(i, rowDataList); // add rowDataList to map of table
            k = 0;
        }
        return tableDataMap;
    }

    Map<String, String> getReadableForeignKeyFields(Object currentRow) {
        Map<String, String> ForeignKeyFieldsList = null;
        String str;
        switch(tableChoice) {
            case "Пользователи/Администраторы":
                break;
            case "Корпуса":
                break;
            case "Кабинеты":
                Cabinet cabinet = (Cabinet)currentRow;
                ForeignKeyFieldsList = new HashMap<String, String>();
                ForeignKeyFieldsList.put("server.entity.Housing", cabinet.getHousing().getTitle());
                break;
            case "Описание кабинетов":
                FunctionCabinet functionCabinet = (FunctionCabinet)currentRow;
                ForeignKeyFieldsList = new HashMap<String, String>();
                ForeignKeyFieldsList.put("server.entity.Cabinet", functionCabinet.getCabinet().getTitle());
                break;
            case "Компоненты справочника":
                StepInstruction stepInstruction = (StepInstruction)currentRow;
                ForeignKeyFieldsList = new HashMap<String, String>();
                ForeignKeyFieldsList.put("server.entity.Instruction", stepInstruction.getInstruction().getName());
                ForeignKeyFieldsList.put("server.entity.Instruction", stepInstruction.getCabinet().getTitle());
                break;
            case "Справочник":
                break;
            case "Сотрудники":
                Employee employee = (Employee)currentRow;
                ForeignKeyFieldsList = new HashMap<String, String>();
                ForeignKeyFieldsList.put("server.entity.Cabinet", employee.getCabinet().getNumber());
                break;
            default:
                break;
        }
        return ForeignKeyFieldsList;

    }

    Map<String, List> getReadableForeignKeyFieldsMap(String tableName) {
        Map<String, List> ForeignKeyFieldsList = new HashMap<String, List>();
        List tmpList;
        String str;
        switch(tableName) {
            case "Пользователи/Администраторы":
                break;
            case "Корпуса":
                break;
            case "Кабинеты":
                tmpList = housingRepository.findAll();
                ForeignKeyFieldsList.put("Housing", tmpList);
                break;
            case "Описание кабинетов":
                tmpList = cabinetRepository.findAll();
                ForeignKeyFieldsList.put("Cabinet", tmpList);
                break;
            case "Компоненты справочника":
                tmpList = cabinetRepository.findAll();
                ForeignKeyFieldsList.put("Cabinet", tmpList);
                tmpList = instructionRepository.findAll();
                ForeignKeyFieldsList.put("Instruction", tmpList);
                break;
            case "Справочник":
                break;
            case "Сотрудники":
                tmpList = cabinetRepository.findAll();
                ForeignKeyFieldsList.put("Cabinet", tmpList);
                break;
            default:
                break;
        }
        return ForeignKeyFieldsList;

    }

    public void searchRecords(String phraseForSearch) {

        this.currentEntityTable.searchPhraseInEntityTable(phraseForSearch);

        /*List tmpList;
        String valueOfRecord;
        detectedRecords = new ArrayList<Integer>();

        for (int i=0; i < tableDataMap.size()-1; i++) {
            tmpList = tableDataMap.get(i);
            for (int k=0; k < tmpList.size(); k++) {
                if (tmpList.get(k) != null) {
                    valueOfRecord = tmpList.get(k).toString();

                    if (valueOfRecord.contains(phraseForSearch)) {
                        detectedRecords.add(i);
                        break;
                    } //if

                } // if

            } // for

        } // for
        */
    }

}
