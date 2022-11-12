package co.edu.javeriana.as.boot.spring.personapp.maria.repository;

import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

}
