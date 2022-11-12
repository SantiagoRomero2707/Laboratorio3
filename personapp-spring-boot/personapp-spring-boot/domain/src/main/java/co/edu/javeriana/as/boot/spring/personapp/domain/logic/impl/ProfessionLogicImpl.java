package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.ProfessionUseCase;

import java.util.List;

public class ProfessionLogicImpl implements ProfessionUseCase {
    @Override
    public String create(Profession profession, Integer flag) {
        return null;
    }

    @Override
    public String edit(Integer id, Profession profession, Integer flag) {
        return null;
    }

    @Override
    public Boolean remove(Integer id, Integer flag) {
        return null;
    }

    @Override
    public Profession findByID(Integer id, Integer flag) {
        return null;
    }

    @Override
    public int count(Integer flag) {
        return 0;
    }

    @Override
    public List<Profession> findAll(Integer flag) {
        return null;
    }
}
