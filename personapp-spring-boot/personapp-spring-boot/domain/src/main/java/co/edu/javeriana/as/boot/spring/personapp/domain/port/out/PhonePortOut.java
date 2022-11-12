package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;

import java.util.List;

public interface PhonePortOut {
    String create(Phone phone);

    String edit(Integer number, Phone phone);

    Boolean remove(Integer number);

    Phone findByID(Integer number);

    int count();

    List<Phone> findAll();
}
