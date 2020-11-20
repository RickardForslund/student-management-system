package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT i FROM Subject i", Subject.class).getResultList();
    }







}
