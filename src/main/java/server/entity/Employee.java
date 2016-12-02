package server.entity;

import org.hibernate.annotations.GenericGenerator;
import server.entity.schedule.Lesson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "patronymic", nullable = true, length = 100)
    private String patronymic;

    @Column(name = "position", nullable = false, length = 300)
    private String position;

    @Column(name = "phone", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Column(name = "photo", nullable = true , columnDefinition = "BLOB")
    private byte[] photo;

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
/*
    @Column(name = "cabinet", nullable = true, length = 4)
    private String cabinet;*/

    //@ToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    //@Column(name = "cabinet", nullable = true, length = 50)

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabinet", referencedColumnName = "id")
    private Cabinet cabinet;

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
      this.cabinet = cabinet;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.EAGER)
    @Column(name = "lessons", nullable = true)
    private Set<Lesson> lessons = new HashSet<>();

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}