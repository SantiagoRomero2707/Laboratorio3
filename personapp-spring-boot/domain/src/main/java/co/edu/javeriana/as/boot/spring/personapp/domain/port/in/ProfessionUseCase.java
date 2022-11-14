package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;

public interface ProfessionUseCase {

    Profession findById(Integer id , Integer flag);

    boolean create(Profession profession, Integer flag);

    boolean edit(Integer id, Profession profession, Integer flag);

    boolean remove(Integer id, Integer flag);

    Integer count( Integer flag);
    
    List<Profession> findAll(Integer flag);
}
