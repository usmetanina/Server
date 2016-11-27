package server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instruction")
public class Instruction {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "name", nullable = true, length = 150)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instruction", fetch = FetchType.EAGER)
    @Column(name = "steps", nullable = true)
    private Set<StepInstruction> steps = new HashSet<>();

    public Instruction() {
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

    public Set<StepInstruction> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepInstruction> steps) {
        this.steps = steps;
    }
}
