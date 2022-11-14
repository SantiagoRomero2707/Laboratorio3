/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PersonRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonResponse;

@Component
public class PersonRestMapper {

    @Autowired
    PhoneRestMapper phoneRestMapper;

    @Autowired
    StudyRestMapper studyRestMapper;

    public List<PersonResponse> fromListPersonaToListPersonaResponse(List<Person> personas) {
        List<PersonResponse> personasResponses = new ArrayList<PersonResponse>();
        for (Person persona : personas) {

            personasResponses.add(fromPersonaToPersonaResponse(persona));
        }
        return personasResponses;
    }

    public Person fromPersonaRequestToPersona(PersonRequest personRequest) {
        if (personRequest == null) {
            return null;
        }
        Person persona = new Person();
        persona.setCc(personRequest.getCc());
        persona.setNombre(personRequest.getNombre());
        persona.setApellido(personRequest.getApellido());
        persona.setEdad(personRequest.getEdad());
        persona.setGenero(personRequest.getGenero());
        persona.setEstudios(studyRestMapper.fromListEstudiosRequestToListEstudios(personRequest.getEstudios()));
        persona.setPhones(phoneRestMapper.fromListTelefonoRequestToListTelefono(personRequest.getTelefonos()));
        return persona;
    }

    public PersonResponse fromPersonaToPersonaResponse(Person persona) {
        if (persona == null) {
            return null;
        }
        PersonResponse personResponse = new PersonResponse();
        personResponse.setCc(persona.getCc());
        personResponse.setNombre(persona.getNombre());
        personResponse.setApellido(persona.getApellido());
        personResponse.setEdad(persona.getEdad());
        personResponse.setGenero(persona.getGenero());
        personResponse.setEstudios(studyRestMapper.fromListEstudiosToListEstudiosResponse(persona.getEstudios()));
        personResponse.setTelefonos(phoneRestMapper.fromListTelefonoToListTelefonoResponse(persona.getPhones()));
        return personResponse;
    }
}
