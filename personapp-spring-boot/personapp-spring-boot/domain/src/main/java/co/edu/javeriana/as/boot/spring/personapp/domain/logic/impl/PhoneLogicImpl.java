package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PhoneUseCase;

import java.util.List;

public class PhoneLogicImpl implements PhoneUseCase {
    @Override
    public String create(Phone phone, Integer flag) {
        return null;
    }

    @Override
    public String edit(Integer number, Phone phone, Integer flag) {
        return null;
    }

    @Override
    public Boolean remove(Integer number, Integer flag) {
        return null;
    }

    @Override
    public Phone findByID(Integer number, Integer flag) {
        return null;
    }

    @Override
    public int count(Integer flag) {
        return 0;
    }

    @Override
    public List<Phone> findAll(Integer flag) {
        return null;
    }
}
