package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;

import java.util.List;

public interface StudyPortOut {
    Study findById(Integer id);

    boolean create(Study study);

    boolean edit(Integer id, Study study);

    boolean remove(Integer id);

    Integer count();

    List<Study> findAll();
}
