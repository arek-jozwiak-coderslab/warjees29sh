package pl.coderslab.person;

import pl.coderslab.person.Person;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
