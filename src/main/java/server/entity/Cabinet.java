package server.entity;

import org.hibernate.annotations.GenericGenerator;
import server.entity.schedule.Lesson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cabinet")
public class Cabinet {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "number", nullable = false, length = 5)
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "housing", referencedColumnName = "id")
    private Housing housing;

    @Column(name = "title", nullable = true, length = 50)
    private String title;

    @Column(name = "work_hours", nullable = true, length = 20)
    private String workHours;

    @Column(name = "lunch_hours", nullable = true, length = 20)
    private String lunchHours;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinet", fetch = FetchType.EAGER)
    @Column(name = "instructions", nullable = true)
    private Set<StepInstruction> instructions = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinet", fetch = FetchType.EAGER)
    @Column(name = "employees", nullable = true)
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinet", fetch = FetchType.EAGER)
    @Column(name = "functions", nullable = true)
    private Set<FunctionCabinet> functions = new HashSet<>();

    public Set<FunctionCabinet> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<FunctionCabinet> functions) {
        this.functions = functions;
    }

    public void addEmployee(Employee employee) {
        //employee.setCabinet(this);
        this.employees.add(employee);
    }
    public Cabinet() {
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    //private String employees;

    public Set<StepInstruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<StepInstruction> instructions) {
        this.instructions = instructions;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinet", fetch = FetchType.EAGER)
    @Column(name = "lessons", nullable = true)
    private Set<Lesson> lessons = new HashSet<>();

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}