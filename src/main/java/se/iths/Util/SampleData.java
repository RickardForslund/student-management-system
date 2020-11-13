package se.iths.Util;

import se.iths.entity.Student;

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
        entityManager.persist(new Student("Rickard","Forslund","Rickard.forslund@live.se", "07227942191"));
        entityManager.persist(new Student("Joakim","Forslund","Joakim.forslund@live.se", "431349211"));
        entityManager.persist(new Student("Pelle","Eriksson","Pelle.eriksson@hotmial.com", "072233291"));
        entityManager.persist(new Student("Runar","Sten","Runar.Sten@live.se", "072513152191"));
        entityManager.persist(new Student("Steve","Andersson","Steve.Andersson@live.se", "0753315191"));
        entityManager.persist(new Student("Isabella","Svensson","Isabella.Svensson@live.se", "0735737532191"));
        entityManager.persist(new Student("Sara","Karlsson","Sara.Karlsson@live.se", "0722631163191"));
        entityManager.persist(new Student("Fia","Svankvist","Fia.Svankvist@live.se", "075133553191"));
        entityManager.persist(new Student("Linus","Axelsson","Linus.Axelsson@live.se", "015351391"));
        entityManager.persist(new Student("Oskar","Blomberg","Oskar.Blomberg@live.se", "07225135391"));
    }
}
