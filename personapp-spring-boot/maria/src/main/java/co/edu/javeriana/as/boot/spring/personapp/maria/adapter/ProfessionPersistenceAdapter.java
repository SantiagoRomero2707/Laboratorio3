package co.edu.javeriana.as.boot.spring.personapp.maria.adapter;
import java.util.List;
import java.util.Optional;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.ProfessionPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.ProfessionEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.mapper.ProfessionMapper;
import co.edu.javeriana.as.boot.spring.personapp.maria.repository.ProfessionRepository;

@Component
public class ProfessionPersistenceAdapter implements ProfessionPortOutMaria {

    @Autowired
    private ProfessionRepository professionRepository;

    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public Profession findById(Integer id) {
        Optional<ProfessionEntity> profesionEntityOptional = professionRepository.findById(id);
        if(profesionEntityOptional.isPresent()) {
            return professionMapper.toProfesionFromProfesionEntity(profesionEntityOptional.get());
        }
        return null;
    }

    @Override
    public boolean create(Profession profession) {
        if (profession.getId() != null) {
            if(professionRepository.findById(profession.getId()).isPresent()) {
                return false;
            }
        }
        ProfessionEntity professionEntity = professionMapper.toProfesionEntityFromProfesion(profession);
        professionRepository.save(professionEntity);
        return true;
    }

    @Override
    public boolean edit(Integer id, Profession profession) {
        if(!professionRepository.findById(id). isPresent()) {
            return false;
        }
        if(profession.getId() != id) {
            remove(id);
        }
        professionRepository.save(professionMapper.toProfesionEntityFromProfesion(profession));
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        Optional<ProfessionEntity> profesionEntityOptional = professionRepository.findById(id);
        if(profesionEntityOptional.isPresent()) {
            professionRepository.delete(profesionEntityOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Integer count() {
        return professionRepository.findAll().size();
    }

    @Override
    public List<Profession> findAll() {
        return professionMapper.toListProfesionFromListProfesionEntity(professionRepository.findAll());
    }


}
