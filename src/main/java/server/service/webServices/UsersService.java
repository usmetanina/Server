package server.service.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.universalEntities.EntityTable;
import server.repository.*;
import server.repository.schedule.*;

import java.lang.reflect.InvocationTargetException;
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
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    WeekRepository weekRepository;
    @Autowired
    DayOfWeekRepository dayOfWeekRepository;
    @Autowired
    TimeOfLessonRepository timeOfLessonRepository;
    @Autowired
    CourseRepository courseRepository;

    //public Map<String, List> dataBaseMap = new HashMap<String, List>(); // for whole database
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
    List<String> ListFunctionCabinetColumnNames = Arrays.asList("ID", "Описание", "Кабинет");
    List<String> ListEmployeeColumnNames = Arrays.asList("ID", "Имя", "Отчество", "Фамилия", "Должность", "Телефон", "Email", "Кабинет");
    List<String> ListInstructionColumnNames = Arrays.asList("ID", "Название");
    List<String> ListStepInstructionColumnNames = Arrays.asList("ID", "Описание компонента", "Номер", "Инструкция", "Кабинет");

    List<String> ListCourseColumnNames = Arrays.asList("ID", "Название");
    List<String> ListDayOfWeekColumnNames = Arrays.asList("ID", "Название дня недели", "Номер");
    List<String> ListFacultyColumnNames = Arrays.asList("ID", "Полное название", "Аббревиатура");
    List<String> ListGroupColumnNames = Arrays.asList("ID", "Название", "Курс", "Факультет");
    List<String> ListLessonColumnNames = Arrays.asList("ID", "Название дисциплины", "Преподаватель", "Кабинет", "День недели", "Неделя", "Группа", "Подгруппа", "Время");
    List<String> ListTimeOfLessonColumnNames = Arrays.asList("ID", "Номер пары", "Время начала", "Время окончания");
    List<String> ListWeekColumnNames = Arrays.asList("ID", "Номер недели");


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

        ColumnNamesForTable.put("Курс", ListCourseColumnNames);
        ColumnNamesForTable.put("День недели", ListDayOfWeekColumnNames);
        ColumnNamesForTable.put("Факультет", ListFacultyColumnNames);
        ColumnNamesForTable.put("Группа", ListGroupColumnNames);
        ColumnNamesForTable.put("Пара/Занятие", ListLessonColumnNames);
        ColumnNamesForTable.put("Время проведения пары/занятия", ListTimeOfLessonColumnNames);
        ColumnNamesForTable.put("Неделя", ListWeekColumnNames);
    }

    void setTablesNames() {
        TablesNames.add("Пользователи/Администраторы");
        TablesNames.add("Корпуса");
        TablesNames.add("Кабинеты");
        TablesNames.add("Описание кабинетов");
        TablesNames.add("Компоненты справочника");
        TablesNames.add("Справочник");
        TablesNames.add("Сотрудники");

        TablesNames.add("Курс");
        TablesNames.add("День недели");
        TablesNames.add("Факультет");
        TablesNames.add("Группа");
        TablesNames.add("Пара/Занятие");
        TablesNames.add("Время проведения пары/занятия");
        TablesNames.add("Неделя");
    }

    public List<String> getColumnsNames(String tableName) {
        return ColumnNamesForTable.get(tableName);
    }

    /*public List getListOfTableObjects(String tableName) {
        return dataBaseMap.get(tableName);
    }
    */

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
            setTablesNames();
            databaseService.initializeEntityMap();
            setDBMap();

            Initialization = true;
        }
    }

    public void setEntityTableChoice() {
        this.currentEntityTable = DBMap.get(this.tableChoice);
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
            case "Курс":
                tmpList = facultyRepository.findAll();
                ForeignKeyFieldsList.put("Faculty", tmpList);
                break;
            case "День недели":
                tmpList = weekRepository.findAll();
                ForeignKeyFieldsList.put("Week", tmpList);
                break;
            case "Факультет":
                break;
            case "Группа":
                tmpList = courseRepository.findAll();
                ForeignKeyFieldsList.put("Course", tmpList);
                break;
            case "Пара/Занятие":
                tmpList = employeeRepository.findAll();
                ForeignKeyFieldsList.put("Employee", tmpList);
                tmpList = cabinetRepository.findAll();
                ForeignKeyFieldsList.put("Cabinet", tmpList);
                tmpList = dayOfWeekRepository.findAll();
                ForeignKeyFieldsList.put("DayOfWeek", tmpList);
                tmpList = timeOfLessonRepository.findAll();
                ForeignKeyFieldsList.put("TimeOfLesson", tmpList);
                break;
            case "Время проведения пары/занятия":
                break;
            case "Неделя":
                tmpList = groupRepository.findAll();
                ForeignKeyFieldsList.put("Group", tmpList);
                break;
            default:
                break;
        }
        return ForeignKeyFieldsList;

    }

    public void searchRecords(String phraseForSearch) {

        this.currentEntityTable.searchPhraseInEntityTable(phraseForSearch);

    }

}
