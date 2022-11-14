package co.edu.javeriana.as.boot.spring.personapp.mongo.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.ProfesionMongoEntity;

@Component
public class ProfesionMongoMapper {
    public ProfesionMongoEntity toProfesionEntityFromProfesion(Profession profession){
        ProfesionMongoEntity profesionEntity = new ProfesionMongoEntity();
        if(profession.getId() != null) {
            profesionEntity.setId(profession.getId());
        }
        profesionEntity.setNom(profession.getNom());
        profesionEntity.setDes(profession.getDes());
        return profesionEntity;
    }

    public Profession toProfesionFromProfesionEntity(ProfesionMongoEntity profesionEntity) {
        Profession profession = new Profession();
        profession.setId(profesionEntity.getId());
        profession.setNom(profesionEntity.getNom());
        profession.setDes(profesionEntity.getDes());
        return profession;
    }

    public List<Profession> toListProfesionFromListProfesionEntity(List<ProfesionMongoEntity> profesionEntities) {
        List<Profession> professions = new ArrayList<Profession>();
        for ( ProfesionMongoEntity ProfesionEntity : profesionEntities){
            professions.add(toProfesionFromProfesionEntity(ProfesionEntity));
        }
        return professions;
    }
}
