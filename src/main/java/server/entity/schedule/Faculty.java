package server.entity.schedule;

import org.hibernate.annotations.GenericGenerator;
import server.entity.schedule.Course;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "full_title", nullable = true, length = 120)
    private String fullTitle;

    @Column(name = "short_title", nullable = true, length = 20)
    private String shortTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty", fetch = FetchType.EAGER)
    @Column(name = "groups", nullable = true)
    private Set<Group> groups = new HashSet<>();

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty", fetch = FetchType.EAGER)
    @Column(name = "courses", nullable = true)*/
    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "faculty_course", catalog = "mkyongdb", joinColumns = {
            @JoinColumn(name = "faculty_id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "course_id",
                    nullable = false) })*/


    public Faculty() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "faculty_course",
            joinColumns = @JoinColumn(name = "faculty_id") ,
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    public Set<Course> courses = new HashSet<>();

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
