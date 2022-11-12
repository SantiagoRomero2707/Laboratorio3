package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaMapper {

    protected Person toPersonaFromPersonaEntity(PersonaEntity pe){
        return null;
    }

    public PersonaEntity toPersonaEntityFromPerson(Person person) {

        PersonaEntity pe = new PersonaEntity();
        pe.setCc(person.getCc());
        pe.setNombre(person.getName());
        pe.setApellido(person.getLast_name());
        pe.setEdad(person.getAge());
        pe.setGenero(person.getGender());
        return pe;
    }

    public List<Person> toListPersonFromListPersonaEntity(List<PersonaEntity> findAll) {
        List<Person> persons = new ArrayList<Person>();
        for (PersonaEntity personaEntity: findAll) {
            persons.add(toPersonFromPersonaEntity(personaEntity));
        }
        return persons;
    }

    private Person toPersonFromPersonaEntity(PersonaEntity personaEntity) {
        Person pe = new Person();

        pe.setCc(personaEntity.getCc());
        pe.setName(personaEntity.getNombre());
        pe.setLast_name(personaEntity.getApellido());
        pe.setAge(personaEntity.getEdad());
        pe.setGender(personaEntity.getGenero());
        return pe;
    }
}
