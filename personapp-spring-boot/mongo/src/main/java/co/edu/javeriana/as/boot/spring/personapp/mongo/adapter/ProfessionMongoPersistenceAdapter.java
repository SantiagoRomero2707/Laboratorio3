package co.edu.javeriana.as.boot.spring.personapp.mongo.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.ProfessionPortOutMongo;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.ProfesionMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.mapper.ProfesionMongoMapper;
import co.edu.javeriana.as.boot.spring.personapp.mongo.repository.ProfesionMongoRepository;

@Component
public class ProfessionMongoPersistenceAdapter implements ProfessionPortOutMongo {

    @Autowired
    private ProfesionMongoRepository profesionRepository;

    @Autowired
    private ProfesionMongoMapper profesionMapper;

    @Override
    public Profession findById(Integer id) {
        Optional<ProfesionMongoEntity> profesionEntityOptional = profesionRepository.findById(id);
        if(profesionEntityOptional.isPresent()) {
            return profesionMapper.toProfesionFromProfesionEntity(profesionEntityOptional.get());
        }
        return null;
    }

    @Override
    public boolean create(Profession profession) {
        if (profession.getId() != null) {
            if(profesionRepository.findById(profession.getId()).isPresent()) {
                return false;
            }
        } else {
            profession.setId(generateId());
        }
        ProfesionMongoEntity profesionEntity = profesionMapper.toProfesionEntityFromProfesion(profession);
        profesionRepository.save(profesionEntity);
        return true;
    }

    @Override
    public boolean edit(Integer id, Profession profession) {
        if(!profesionRepository.findById(id). isPresent()) {
            return false;
        }
        if(profession.getId() != id) {
            remove(id);
        }
        profesionRepository.save(profesionMapper.toProfesionEntityFromProfesion(profession));
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        Optional<ProfesionMongoEntity> profesionEntityOptional = profesionRepository.findById(id);
        if(profesionEntityOptional.isPresent()) {
            profesionRepository.delete(profesionEntityOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Integer count() {
        return profesionRepository.findAll().size();
    }

    @Override
    public List<Profession> findAll() {
        return profesionMapper.toListProfesionFromListProfesionEntity(profesionRepository.findAll());
    }

    public Integer generateId() {
        List<ProfesionMongoEntity> profesionEntities = profesionRepository.findAll();
        Integer max = 0;
        for (ProfesionMongoEntity profesionMongoEntity : profesionEntities) {
            if (profesionMongoEntity.getId() > max) {
                max = profesionMongoEntity.getId();
            }
        }
        return max + 1;
    }
}
