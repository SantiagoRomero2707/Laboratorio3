package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import java.util.List;

public interface ProfessionUseCase {

    String create(Profession profession, Integer flag);

    String edit(Integer id, Profession profession, Integer flag);

    Boolean remove(Integer id, Integer flag);

    Profession findByID(Integer id, Integer flag);

    int count(Integer flag);

    List<Profession> findAll(Integer flag);
}
