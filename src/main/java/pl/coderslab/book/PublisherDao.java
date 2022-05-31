package pl.coderslab.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.person.Person;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person publisher) {
        entityManager.merge(publisher);
    }

    public void delete(Person publisher) {
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }
}
