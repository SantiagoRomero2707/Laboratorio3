package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;

import java.util.List;

public interface ProfessionPortOut {

    String create(Profession profession);

    String edit(Integer id, Profession profession);

    Boolean remove(Integer id);

    Profession findByID(Integer id);

    int count();

    List<Profession> findAll();
}
