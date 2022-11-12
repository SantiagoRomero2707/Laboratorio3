package co.edu.javeriana.as.boot.spring.personapp.maria.repository;

import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiosRepository extends JpaRepository<EstudiosEntity, EstudiosPK> {
}
