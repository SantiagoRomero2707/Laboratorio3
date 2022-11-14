package co.edu.javeriana.as.boot.spring.personapp.mongo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;

@Component
public class PersonaMongoMapper {
    @Autowired
    TelefonoMongoMapper telefonoMapper;

    @Autowired
    EstudiosMongoMapper estudiosMapper;

    public PersonaMongoEntity toPersonaEntityFromPersona(Person persona){
        PersonaMongoEntity personaEntity = new PersonaMongoEntity();
        personaEntity.setCc(persona.getCc());
        personaEntity.setNombre(persona.getNombre());
        personaEntity.setApellido(persona.getApellido());
        personaEntity.setGenero(persona.getGenero());
        personaEntity.setEdad(persona.getEdad());
        personaEntity.setTelefonos(telefonoMapper.toListTelefonoEntityFromListTelefono(persona.getPhones(), personaEntity));
        personaEntity.setEstudios(estudiosMapper.toListEstudiosEntityFromListEstudios(persona.getEstudios(), personaEntity));
        return personaEntity;
    }

    public Person toPersonaFromPersonaEntity(PersonaMongoEntity personaEntity) {
        Person persona = new Person();
        persona.setCc(personaEntity.getCc());
        persona.setApellido(personaEntity.getApellido());
        persona.setNombre(personaEntity.getNombre());
        persona.setGenero(personaEntity.getGenero());
        persona.setEdad(personaEntity.getEdad());
        persona.setPhones(telefonoMapper.toListTelefonoFromListTelefonoEntity(personaEntity.getTelefonos()));
        persona.setEstudios(estudiosMapper.toListEstudiosFromListEstudiosEntity(personaEntity.getEstudios()));

        return persona;
    }

    public List<Person> toListPersonaFromListPersonaEntity(List<PersonaMongoEntity> personaEntities) {
        List<Person> personas = new ArrayList<Person>();
        for ( PersonaMongoEntity personaEntity : personaEntities){
            personas.add(toPersonaFromPersonaEntity(personaEntity));
        }
        return personas;
    }
}
