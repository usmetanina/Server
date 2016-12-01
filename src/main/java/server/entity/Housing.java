package server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "housing")
public class Housing {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "number", nullable = false, length = 5)
    private String number;

    @Column(name = "title", nullable = true, length = 50)
    private String title;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "house", nullable = false, length = 10)
    private String house;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "housing", fetch = FetchType.EAGER)
    @Column(name = "cabinets", nullable = true)
    private Set<Cabinet> cabinets = new HashSet<>();

    public void addCabinet(Cabinet cabinet) {
        this.cabinets.add(cabinet);
    }

    public Housing() {
    }

    public Housing(String number, String title, String city, String street, String house, Set<Cabinet> cabinets) {
        this.number = number;
        this.title = title;
        this.city = city;
        this.street = street;
        this.house = house;
        this.cabinets = cabinets;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Set<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(Set<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}