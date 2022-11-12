package co.edu.javeriana.as.boot.spring.personapp.rest.controller.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.rest.adapter.PersonAdapter;
import co.edu.javeriana.as.boot.spring.personapp.rest.controller.PersonaController;
import co.edu.javeriana.as.boot.spring.personapp.rest.mapper.PersonaRestMapper;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaControllerImpl implements PersonaController {

    @Autowired
    public PersonAdapter personaUseCase;

    @Autowired
    public PersonaRestMapper personaRestMapper;

    @Value("${app.db}")
    private int appDb;

    @Override
    @GetMapping
    public List<PersonaResponse> buscar(){
        List<Person> personas = personaUseCase.findAll(appDb);
        return personaRestMapper.
    }

}
