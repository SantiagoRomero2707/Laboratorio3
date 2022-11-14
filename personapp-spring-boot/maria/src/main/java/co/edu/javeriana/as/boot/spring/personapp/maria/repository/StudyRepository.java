package co.edu.javeriana.as.boot.spring.personapp.maria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosPK;

@Repository
public interface StudyRepository extends JpaRepository<EstudiosEntity, EstudiosPK> {
    
}
