package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;

import java.util.List;

public interface StudyPortOut {
    String create(Study study);

    String edit(Person person, Profession profession, Study study);

    Boolean remove(Person person, Profession profession);

    Study findByID(Person person, Profession profession);

    int count();

    List<Study> findAll();
}
