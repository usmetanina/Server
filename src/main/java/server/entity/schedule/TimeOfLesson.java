package server.entity.schedule;

import org.hibernate.annotations.GenericGenerator;
import server.entity.schedule.Lesson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "time_lesson")
public class TimeOfLesson {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "number_lesson", nullable = false, length = 120)
    private int numberOfLesson;

    @Column(name = "time_begin", nullable = false, length = 20)
    private String timeBegin;

    @Column(name = "time_end", nullable = false, length = 20)
    private String timeEnd;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time", fetch = FetchType.EAGER)
    @Column(name = "lessons", nullable = true)
    private Set<Lesson> lessons = new HashSet<>();

    public TimeOfLesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
