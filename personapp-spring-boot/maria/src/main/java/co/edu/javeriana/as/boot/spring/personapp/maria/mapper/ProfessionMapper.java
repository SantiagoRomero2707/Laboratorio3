package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.ProfessionEntity;

@Component
public class ProfessionMapper {

    public ProfessionEntity toProfesionEntityFromProfesion(Profession profession){
        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setId(profession.getId());
        professionEntity.setNom(profession.getNom());
        professionEntity.setDes(profession.getDes());
        return professionEntity;
    }

    public Profession toProfesionFromProfesionEntity(ProfessionEntity professionEntity) {
        Profession profession = new Profession();
        profession.setId(professionEntity.getId());
        profession.setNom(professionEntity.getNom());
        profession.setDes(professionEntity.getDes());
        return profession;
    }

    public List<Profession> toListProfesionFromListProfesionEntity(List<ProfessionEntity> profesionEntities) {
        List<Profession> professions = new ArrayList<Profession>();
        for ( ProfessionEntity ProfessionEntity : profesionEntities){
            professions.add(toProfesionFromProfesionEntity(ProfessionEntity));
        }
        return professions;
    }
}
