package co.edu.javeriana.as.boot.spring.personapp.maria.adapter;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.PersonPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonaEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.mapper.PersonaMapper;
import co.edu.javeriana.as.boot.spring.personapp.maria.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonaPersistenceAdapter implements PersonPortOutMaria {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public String create(Person person) {
        PersonaEntity persona = personaMapper.toPersonaEntityFromPerson(person);

        if(personaRepository.save(persona) == null){
            return "No se creo el objeto";
        }else{
            return "Se creo el objeto";
        }


    }

    @Override
    public String edit(Integer id, Person person) {
        return null;
    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Person findByID(Integer id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Person> findAll() {
        return personaMapper.toListPersonFromListPersonaEntity(personaRepository.findAll());
    }
}
