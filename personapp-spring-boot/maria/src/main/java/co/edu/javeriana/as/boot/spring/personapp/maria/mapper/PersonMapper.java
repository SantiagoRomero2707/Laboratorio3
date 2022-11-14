/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonEntity;

/**
 *
 * @author aasanchez
 */
@Component
public class PersonMapper {

    @Autowired
    PhoneMapper phoneMapper;

    @Autowired
    StudyMapper studyMapper;

    public PersonEntity toPersonaEntityFromPersona(Person persona){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setCc(persona.getCc());
        personEntity.setNombre(persona.getNombre());
        personEntity.setApellido(persona.getApellido());
        personEntity.setGenero(persona.getGenero());
        personEntity.setEdad(persona.getEdad());
        personEntity.setTelefonos(phoneMapper.toListTelefonoEntityFromListTelefono(persona.getPhones(), personEntity));
        personEntity.setEstudios(studyMapper.toListEstudiosEntityFromListEstudios(persona.getEstudios(), personEntity));
        return personEntity;
    }

    public Person toPersonaFromPersonaEntity(PersonEntity personEntity) {
        Person persona = new Person();
        persona.setCc(personEntity.getCc());
        persona.setApellido(personEntity.getApellido());
        persona.setNombre(personEntity.getNombre());
        persona.setGenero(personEntity.getGenero());
        persona.setEdad(personEntity.getEdad());
        persona.setPhones(phoneMapper.toListTelefonoFromListTelefonoEntity(personEntity.getTelefonos()));
        persona.setEstudios(studyMapper.toListEstudiosFromListEstudiosEntity(personEntity.getEstudios()));

        return persona;
    }

    public List<Person> toListPersonaFromListPersonaEntity(List<PersonEntity> personaEntities) {
        List<Person> personas = new ArrayList<Person>();
        for ( PersonEntity personEntity : personaEntities){
            personas.add(toPersonaFromPersonaEntity(personEntity));
        }
        return personas;
    }
}
