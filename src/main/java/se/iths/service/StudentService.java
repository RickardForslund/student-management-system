package se.iths.service;

import se.iths.entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateTodo(Student student) {
        entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public Student findStudentByfirstName(String firstName) {return entityManager.find(Student.class, firstName);}

    public Student findStudentByLastName(String lastName) {return entityManager.find(Student.class, lastName);}

    public Student findStudentByemail(String email) {return entityManager.find(Student.class, email);}

    public Student findStudentByphoneNumber(int phoneNumber) {return entityManager.find(Student.class, phoneNumber);}
}
