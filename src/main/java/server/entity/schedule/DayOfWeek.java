package server.entity.schedule;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "day_week")
public class DayOfWeek {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "day_of_week", nullable = false, length = 120)
    private String dayOfWeek;

    @Column(name = "number_of_day_of_week", nullable = false)
    private int numberOfDayOfWeek;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dayOfWeek", fetch = FetchType.EAGER)
    @Column(name = "lessons", nullable = true)
    private Set<Lesson> lessons = new HashSet<>();

    public DayOfWeek() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getNumberOfDayOfWeek() {
        return numberOfDayOfWeek;
    }

    public void setNumberOfDayOfWeek(int numberOfDayOfWeek) {
        this.numberOfDayOfWeek = numberOfDayOfWeek;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
