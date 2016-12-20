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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_student", referencedColumnName = "id")
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
