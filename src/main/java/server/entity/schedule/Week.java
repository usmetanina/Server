package server.entity.schedule;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "week_school")
public class Week {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "number", nullable = false)
    private int number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "week", fetch = FetchType.EAGER)
    @Column(name = "lessons", nullable = true)
    private Set<Lesson> lessons = new HashSet<>();

    public Week() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
