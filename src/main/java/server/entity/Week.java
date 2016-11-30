package server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "week")
public class Week {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "number_of_week", nullable = false)
    private int numberOWeek;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group", referencedColumnName = "id")
    private Group group;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "week", fetch = FetchType.EAGER)
    @Column(name = "days", nullable = true)
    private Set<DayOfWeek> days = new HashSet<>();

    public Week() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOWeek() {
        return numberOWeek;
    }

    public void setNumberOWeek(int numberOWeek) {
        this.numberOWeek = numberOWeek;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(Set<DayOfWeek> days) {
        this.days = days;
    }
}
