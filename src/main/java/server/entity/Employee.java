package server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "position", nullable = true, length = 300)
    private String position;

    @Column(name = "phone", nullable = true, length = 11)
    private String phoneNumber;

    @Column(name = "email", nullable = true, length = 50)
    private String email;

    /*
    @Column(name = "cabinet", nullable = true, length = 4)
    private String cabinet;*/

    //@ToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    //@Column(name = "cabinet", nullable = true, length = 50)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabinet_number", referencedColumnName = "number")
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
}