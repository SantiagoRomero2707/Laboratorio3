package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.StudyUseCase;

import java.util.List;

public class StudyLogicImpl implements StudyUseCase {
    @Override
    public String create(Study study, Integer flag) {
        return null;
    }

    @Override
    public String edit(Person person, Profession profession, Study study, Integer flag) {
        return null;
    }

    @Override
    public Boolean remove(Person person, Profession profession, Integer flag) {
        return null;
    }

    @Override
    public Study findByID(Person person, Profession profession, Integer flag) {
        return null;
    }

    @Override
    public int count(Integer flag) {
        return 0;
    }

    @Override
    public List<Study> findAll(Integer flag) {
        return null;
    }
}
