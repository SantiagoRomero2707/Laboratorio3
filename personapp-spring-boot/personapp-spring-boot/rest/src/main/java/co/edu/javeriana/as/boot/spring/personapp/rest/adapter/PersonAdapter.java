package co.edu.javeriana.as.boot.spring.personapp.rest.adapter;


import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Este utiliza los mapper y el controlador utiliza a esta clase
public class PersonAdapter implements PersonUseCase {

    @Autowired
    private PersonUseCase personUseCase;

    @Override
    public String create(Person person, Integer flag) {
        return personUseCase.create(person, flag);
    }

    @Override
    public String edit(Integer id, Person person, Integer flag) {
        return null;
    }

    @Override
    public Boolean remove(Integer id, Integer flag) {
        return null;
    }

    @Override
    public Person findByID(Integer id, Integer flag) {
        return null;
    }

    @Override
    public int count(Integer flag) {
        return 0;
    }

    @Override
    public List<Person> findAll(Integer flag) {
        return null;
    }
}
