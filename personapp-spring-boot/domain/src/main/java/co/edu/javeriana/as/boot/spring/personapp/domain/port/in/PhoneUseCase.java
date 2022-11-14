package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;

import java.util.List;

public interface PhoneUseCase {

    Phone findById(Integer cc, Integer flag);

    boolean create(Phone phone, Integer flag);

    boolean edit(Integer cc, Phone phone, Integer flag);

    boolean remove(Integer cc, Integer flag);

    Integer count(Integer flag);

    List<Phone> findAll(Integer flag);

}
