package co.edu.javeriana.as.boot.spring.personapp.rest.controller.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonUseCase;
import co.edu.javeriana.as.boot.spring.personapp.rest.mapper.PersonRestMapper;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PersonRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/study")
public class StudyControllerImpl {
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
