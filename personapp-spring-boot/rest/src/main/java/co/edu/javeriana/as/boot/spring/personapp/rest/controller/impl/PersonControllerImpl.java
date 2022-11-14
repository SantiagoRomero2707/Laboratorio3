/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonUseCase;
import co.edu.javeriana.as.boot.spring.personapp.rest.controller.PersonController;
import co.edu.javeriana.as.boot.spring.personapp.rest.mapper.PersonRestMapper;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PersonRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonResponse;

@RestController
@RequestMapping("/persona")
public class PersonControllerImpl implements PersonController {

    @Value("${app.db}")
    private int bandera;
    
    @Autowired
    private PersonUseCase personUseCase;

    @Autowired
    private PersonRestMapper personRestMapper;

  

    @Override
    @GetMapping
    public List<PersonResponse> buscar() {
       List<Person> personas = personUseCase.findAll(0);
        return personRestMapper.fromListPersonaToListPersonaResponse(personas);
    }

    @Override
    @PutMapping("/{cc}")
    public Boolean actualizar(@PathVariable("cc") Integer cc, @RequestBody PersonRequest personaPostRequest) {
        Person persona = personRestMapper.fromPersonaRequestToPersona(personaPostRequest);
        Boolean salida = personUseCase.edit(persona.getCc(), persona, bandera);
        return salida;
    }

    @Override
    @PostMapping
    public Boolean agregar(@RequestBody PersonRequest personRequest) {
        Person persona = personRestMapper.fromPersonaRequestToPersona(personRequest);
        Boolean salida = personUseCase.create(persona, bandera);
        return salida;
    }

    @Override
    @DeleteMapping("/{cc}")
    public Boolean eliminar(@PathVariable("cc") Integer cc) {
        Boolean salida = personUseCase.remove(cc, bandera);
        return salida;
    }

    @Override
    @GetMapping("/{cc}")
    public PersonResponse consultar(@PathVariable("cc") Integer Cc) {
        Person persona = personUseCase.findById(Cc, bandera);
        PersonResponse personResponse = personRestMapper.fromPersonaToPersonaResponse(persona);
        return personResponse;
    }
    
}
