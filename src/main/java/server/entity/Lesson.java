package server.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "name_subject", nullable = true, length = 120)
    private String nameOfSubject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabinet", referencedColumnName = "id")
    private Cabinet cabinet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dayOfWeek", referencedColumnName = "id")
    private DayOfWeek dayOfWeek;

    @Column(name = "type_lesson", nullable = true, length = 20)
    private String typeOfLesson;

    @Column(name = "subgroup", nullable = true)
    private int subgroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "time", referencedColumnName = "id")
    private TimeOfLesson time;

    public Lesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(int subgroup) {
        this.subgroup = subgroup;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public String getTypeOfLesson() {
        return typeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    public TimeOfLesson getTime() {
        return time;
    }

    public void setTime(TimeOfLesson time) {
        this.time = time;
    }
}
