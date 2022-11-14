package co.edu.javeriana.as.boot.spring.personapp.rest.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import co.edu.javeriana.as.boot.spring.personapp.rest.request.ProfessionRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.ProfessionResponse;

public interface ProfessionController {

    @GetMapping
    public List<ProfessionResponse> buscar();

    @PutMapping
    public Boolean create(ProfessionRequest profesionPostRequest);

    @PostMapping
    public Boolean update(Integer id, ProfessionRequest ProfesionPostRequest);

    @DeleteMapping
    public Boolean remove ( Integer Cc);

    @GetMapping
    public ProfessionResponse findById(Integer Cc);
    
}
