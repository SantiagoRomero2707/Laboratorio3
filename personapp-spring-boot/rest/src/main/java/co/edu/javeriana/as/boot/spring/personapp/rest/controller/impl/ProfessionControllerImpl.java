package co.edu.javeriana.as.boot.spring.personapp.rest.controller.impl;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
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

import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.ProfessionUseCase;
import co.edu.javeriana.as.boot.spring.personapp.rest.controller.ProfessionController;
import co.edu.javeriana.as.boot.spring.personapp.rest.mapper.ProfessionRestMapper;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.ProfessionRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.ProfessionResponse;

@RestController
@RequestMapping("/profesion")
public class ProfessionControllerImpl implements ProfessionController {


    @Override
    public List<ProfessionResponse> buscar() {
        return null;
    }

    @Override
    public Boolean agregar(ProfessionRequest profesionPostRequest) {
        return null;
    }

    @Override
    public Boolean actualizar(Integer id, ProfessionRequest ProfesionPostRequest) {
        return null;
    }

    @Override
    public Boolean eliminar(Integer Cc) {
        return null;
    }

    @Override
    public ProfessionResponse consultar(Integer Cc) {
        return null;
    }
}
