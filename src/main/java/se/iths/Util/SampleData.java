package se.iths.Util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.rest.SubjectsTypes;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleData {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Rickard", "Forslund", "Rickard.forslund@live.se", "07227942191");
        Student student2 = new Student("Joakim", "Forslund", "Joakim.forslund@live.se", "431349211");
        Student student3 = new Student("Pelle", "Eriksson", "Pelle.eriksson@hotmial.com", "072233291");

        Teacher teacher1 = new Teacher("Pontus", "Redig");
        Teacher teacher2 = new Teacher("Martin", "Blomberg");

        Subject subject1 = new Subject("Javascript");
        Subject subject2 = new Subject("C++");
        Subject subject3 = new Subject("Java");
        Subject subject4 = new Subject("C#");


        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject3);
        student2.addSubject(subject4);
        student3.addSubject(subject1);

        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject4);


        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);

    }
}
