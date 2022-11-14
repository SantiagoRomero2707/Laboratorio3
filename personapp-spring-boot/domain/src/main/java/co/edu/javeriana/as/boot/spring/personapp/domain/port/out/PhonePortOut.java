package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;


import java.util.List;

public interface PhonePortOut {
    Phone findById(Integer id);

    boolean create(Phone phone);

    boolean edit(Integer id, Phone phone);

    boolean remove(Integer id);

    Integer count();

    List<Phone> findAll();

}
