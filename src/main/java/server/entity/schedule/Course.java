package server.entity.schedule;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "title", nullable = true, length = 120)
    private String title;

    @ManyToMany
    @JoinTable(name = "faculty_course",
            joinColumns = @JoinColumn(name = "course_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "faculty_id"))
    private Set<Faculty> faculties = new HashSet<>();

    //@ManyToMany(cascade=CascadeType.ALL, mappedBy="course_id")
    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    /*@ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "faculty", referencedColumnName = "id")*/

    //private Faculty faculty;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.EAGER)
    @Column(name = "groups", nullable = true)
    private Set<Group> groups = new HashSet<>();

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

}
