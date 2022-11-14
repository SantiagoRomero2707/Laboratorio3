/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.adapter;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.PersonPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.mapper.PersonMapper;
import co.edu.javeriana.as.boot.spring.personapp.maria.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonPersistenceAdapter implements PersonPortOutMaria {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person findById(Integer cc) {
        Optional<PersonEntity> personaEntityOptional = personRepository.findById(cc);
        if(personaEntityOptional.isPresent()) {
            return personMapper.toPersonaFromPersonaEntity(personaEntityOptional.get());
        }
        return null;
    }

    @Override
    public boolean create(Person persona) {
        if(personRepository.findById(persona.getCc()).isPresent()) {
            return false;
        }
        if (persona.getEstudios() == null) {
            persona.setEstudios(new ArrayList<>());
        }
        if(persona.getPhones() == null) {
            persona.setEstudios(new ArrayList<>());
        }
        PersonEntity personEntity = personMapper.toPersonaEntityFromPersona(persona);
        personRepository.save(personEntity);
        return true;
        
    }

    @Override
    public boolean edit(Integer cc, Person persona) {
        if(!personRepository.findById(cc).isPresent()) {
            return false;
        }
        if(persona.getCc() != cc) {
            remove(cc);
        }
        personRepository.save(personMapper.toPersonaEntityFromPersona(persona));
        return true;
    }

    @Override
    public boolean remove(Integer cc) {
        Optional<PersonEntity> personaEntityOptional = personRepository.findById(cc);
        if(personaEntityOptional.isPresent()) {
            personRepository.delete(personaEntityOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Integer count() {
        return personRepository.findAll().size();
    }

    @Override
    public List<Person> findAll() {
        return personMapper.toListPersonaFromListPersonaEntity(personRepository.findAll());
    }

  
    
}
