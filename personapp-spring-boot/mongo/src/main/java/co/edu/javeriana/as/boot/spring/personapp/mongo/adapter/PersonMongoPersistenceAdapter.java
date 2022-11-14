package co.edu.javeriana.as.boot.spring.personapp.mongo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.PersonPortOutMongo;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.mapper.PersonaMongoMapper;
import co.edu.javeriana.as.boot.spring.personapp.mongo.repository.PersonaMongoRepository;

@Component
public class PersonMongoPersistenceAdapter implements PersonPortOutMongo {
    
    @Autowired
    private PersonaMongoRepository personaRepository;

    @Autowired
    private PersonaMongoMapper personaMapper;

    @Override
    public Person findById(Integer cc) {
        Optional<PersonaMongoEntity> personaEntityOptional = personaRepository.findById(cc);
        if(personaEntityOptional.isPresent()) {
            return personaMapper.toPersonaFromPersonaEntity(personaEntityOptional.get());
        }
        return null;
    }

    @Override
    public boolean create(Person persona) {
        if(personaRepository.findById(persona.getCc()).isPresent()) {
            return false;
        }
        if (persona.getEstudios() == null) {
            persona.setEstudios(new ArrayList<>());
        }
        if(persona.getPhones() == null) {
            persona.setEstudios(new ArrayList<>());
        }
        PersonaMongoEntity personaEntity  = personaMapper.toPersonaEntityFromPersona(persona);
        personaRepository.save(personaEntity);
        return true;
        
    }

    @Override
    public boolean edit(Integer cc, Person persona) {
        if(!personaRepository.findById(cc).isPresent()) {
            return false;
        }
        if(persona.getCc() != cc) {
            remove(cc);
        }
        personaRepository.save(personaMapper.toPersonaEntityFromPersona(persona));
        return true;
    }

    @Override
    public boolean remove(Integer cc) {
        Optional<PersonaMongoEntity> personaEntityOptional = personaRepository.findById(cc);
        if(personaEntityOptional.isPresent()) {
            personaRepository.delete(personaEntityOptional.get());
            return true;
        }
        return false;
    }
    @Override
    public Integer count() {
        return personaRepository.findAll().size();
    }
    
    @Override
    public List<Person> findAll() {
        return personaMapper.toListPersonaFromListPersonaEntity(personaRepository.findAll());
    }
}
