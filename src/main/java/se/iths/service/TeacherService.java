package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT t from Teacher t", Teacher.class).getResultList();
    }


    public Set<Student> getSpeceficStudentForSubject(String teacherName, String subjectName){
        var subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT x FROM Subject x " +
                        "INNER JOIN FETCH x.teacher t " +
                        "INNER JOIN FETCH x.students s " +
                        "WHERE t.firstname = :teacherName " +
                        "AND x.name = :subjectName")
                .setParameter("teacherName", teacherName)
                .setParameter("subjectName", subjectName)
                .getSingleResult();

        return subject.getStudents();
    }

}
