package se.iths.Util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

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

        //<editor-fold desc="Add Students">
        Student student1 = new Student("Rickard", "Forslund", "Rickard.forslund@live.se", "07227942191");
        Student student2 = new Student("Joakim", "Forslund", "Joakim.forslund@live.se", "4313435359211");
        Student student3 = new Student("Pelle", "Eriksson", "Pelle.eriksson@hotmial.com", "072237533573291");
        Student student4 = new Student("Oskar", "Gustavsson", "Oskar.Gustavsson@hotmial.com", "0356355753791");
        Student student5 = new Student("Peter", "Ask", "Peter.Ask@hotmial.com", "076536533291");
        Student student6 = new Student("Julia", "Petterson", "Julia.Petterson@hotmial.com", "073563653291");
        Student student7 = new Student("Simone", "Vig", "Simone.Vig@hotmial.com", "07753333291");
        //</editor-fold>
        //<editor-fold desc="Add Teachers">
        Teacher teacher1 = new Teacher("Pontus", "Redig");
        Teacher teacher2 = new Teacher("Martin", "Blomberg");
        //</editor-fold>
        //<editor-fold desc="Add subjects">
        Subject subject1 = new Subject("Javascript");
        Subject subject2 = new Subject("C++");
        Subject subject3 = new Subject("Java");
        Subject subject4 = new Subject("C#");
        //</editor-fold>
        //<editor-fold desc="Add Student">
        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject3);
        student1.addSubject(subject4);

        student2.addSubject(subject1);
        student2.addSubject(subject3);
        student2.addSubject(subject4);

        student3.addSubject(subject1);
        student3.addSubject(subject2);
        student3.addSubject(subject3);

        student4.addSubject(subject1);
        student4.addSubject(subject4);

        student5.addSubject(subject2);

        student6.addSubject(subject1);
        student6.addSubject(subject2);
        student6.addSubject(subject4);

        student7.addSubject(subject1);
        student7.addSubject(subject2);
        student7.addSubject(subject3);
        student7.addSubject(subject4);
        //</editor-fold>

        //<editor-fold desc="AddSubjectsToTeachers">
        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject4);
        //</editor-fold>
        //<editor-fold desc="PersistAllStudentsAndTeachers">
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        entityManager.persist(student6);
        entityManager.persist(student7);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        //</editor-fold>

    }
}
