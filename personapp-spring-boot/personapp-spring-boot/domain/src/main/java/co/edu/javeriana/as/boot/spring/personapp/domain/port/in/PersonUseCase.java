package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import java.util.List;

public interface PersonUseCase {

    String create(Person person, Integer flag);

    String edit(Integer id, Person person, Integer flag);

    Boolean remove(Integer id, Integer flag);

    Person findByID(Integer id, Integer flag);

    int count(Integer flag);

    List<Person> findAll(Integer flag);

}
