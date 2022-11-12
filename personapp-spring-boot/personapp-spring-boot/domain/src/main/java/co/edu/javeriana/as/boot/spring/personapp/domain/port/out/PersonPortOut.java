package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;

import java.util.List;

public interface PersonPortOut {

    String create(Person person);

    String edit(Integer id, Person person);

    Boolean remove(Integer id);

    Person findByID(Integer id);

    int count();

    List<Person> findAll();

}
