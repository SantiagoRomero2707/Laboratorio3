package co.edu.javeriana.as.boot.spring.personapp.rest.controller.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PhoneUseCase;
import co.edu.javeriana.as.boot.spring.personapp.rest.controller.PhoneController;
import co.edu.javeriana.as.boot.spring.personapp.rest.mapper.PhoneRestMapper;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PhoneRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PhoneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/phone")
public class PhoneControllerImpl implements PhoneController {
    @Value("${app.db}")
    private int bandera;

    @Autowired
    private PhoneUseCase phoneUseCase;

    @Autowired
    private PhoneRestMapper phoneRestMapper;


    @Override
    @GetMapping
    public List<PhoneResponse> findById() {
        List<Phone> phone = phoneUseCase.findAll(0);
        return phoneRestMapper.fromListTelefonoToListTelefonoResponse(phone);
    }

    @Override
    @PutMapping("/{cc}")
    public Boolean update(@PathVariable("cc") Integer cc, @RequestBody PhoneRequest phonePostRequest) {
        Phone phone = phoneRestMapper.fromTelefonoRequestToTelefono(phonePostRequest);
        Boolean salida = phoneUseCase.edit(Integer.valueOf(phone.getNum()), phone, bandera);
        return salida;
    }

    @Override
    @PostMapping
    public Boolean create(@RequestBody Phone phoneRequest) {
        PhoneResponse phone = phoneRestMapper.fromTelefonoToTelefonoResponse(phoneRequest);
        Boolean salida = phoneUseCase.create(phone, bandera);
        return salida;
    }


}
