package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Student> getAllTeachers() {

        return entityManager.createQuery("SELECT b from Teacher b", Student.class).getResultList();
    }

    public Set<Student> getSpeceficStudentForSubject(String teacherName, String subjectName){
        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT x FROM Subject x INNER JOIN FETCH x.teacher t INNER JOIN FETCH x.students s WHERE t.firstname = :teacherName AND x.name = :subjectName")
                .setParameter("teacherName", teacherName).setParameter("subjectName", subjectName).getSingleResult();

        Set<Student> studentReslut = subject.getStudents();
        return studentReslut;
    }

        /*
          Item item = (Item) entityManager
                .createQuery("SELECT DISTINCT i FROM Item i INNER JOIN FETCH i.buyer b INNER JOIN FETCH i.users u WHERE b.firstName = :buyerName AND i.name = :itemName")
                .setParameter("buyerName", buyerName).setParameter("itemName", itemName).getSingleResult();
     */


}