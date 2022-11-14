package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;

public interface ProfessionPortOut {
    Profession findById(Integer id);

    boolean create(Profession profession);

    boolean edit(Integer id, Profession profession);

    boolean remove(Integer id);

    Integer count();

    List<Profession> findAll();
}
