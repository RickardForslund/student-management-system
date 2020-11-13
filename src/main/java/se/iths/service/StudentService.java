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

    public List<Student> findStudentByfirstName(String firstName) {
        String query = "SELECT i FROM Student i WHERE i.firstName = '" + firstName + "'";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    public List<Student> findStudentBylastName(String lastName) {
        String query = "SELECT i FROM Student i WHERE i.lastName = '" + lastName + "'";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    public void deleteStudent(Long id) {
        Student deleteThisUser = entityManager.find(Student.class, id);
        entityManager.remove(deleteThisUser);
    }

}
