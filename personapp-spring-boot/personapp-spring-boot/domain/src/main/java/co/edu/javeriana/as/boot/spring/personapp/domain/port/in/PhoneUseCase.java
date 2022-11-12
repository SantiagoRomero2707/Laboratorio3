package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import java.util.List;

public interface PhoneUseCase {
    String create(Phone phone, Integer flag);

    String edit(Integer number, Phone phone, Integer flag);

    Boolean remove(Integer number, Integer flag);

    Phone findByID(Integer number, Integer flag);

    int count(Integer flag);

    List<Phone> findAll(Integer flag);
}
