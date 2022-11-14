package co.edu.javeriana.as.boot.spring.personapp.rest.controller;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PhoneRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PhoneResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface PhoneController {

    @GetMapping
    public List<PhoneResponse> buscar();

    @PutMapping
    public Boolean create(Phone phonePostRequest);

    @PostMapping
    public Boolean update(Integer id, PhoneRequest phonePostRequest);

    @DeleteMapping
    public Boolean remove ( Integer Cc);

    @GetMapping
    public PhoneResponse findById(Integer Cc);

    @GetMapping
    List<PhoneResponse> findById();
}
