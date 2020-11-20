package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    //<editor-fold desc="Konstruktor">
    public Teacher(@NotEmpty String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Teacher() {
    }
    //</editor-fold>

    //<editor-fold desc="Fält">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String firstname;
    private String lastname;
    //</editor-fold>

    //<editor-fold desc="Relations">
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private Set<Subject> subjects = new HashSet<>();
    //</editor-fold>


    public void addSubject(Subject subject){
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
