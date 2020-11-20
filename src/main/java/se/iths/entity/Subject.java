package se.iths.entity;

import se.iths.rest.SubjectsTypes;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    //<editor-fold desc="Konstruktorer">
    public Subject() {

    }

    public Subject(@NotEmpty String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="Fält">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;
    //</editor-fold>

    //<editor-fold desc="Relations">
    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public void setTeacher(Teacher teacher) {this.teacher = teacher;}


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @JsonbTransient
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    //</editor-fold>


}
