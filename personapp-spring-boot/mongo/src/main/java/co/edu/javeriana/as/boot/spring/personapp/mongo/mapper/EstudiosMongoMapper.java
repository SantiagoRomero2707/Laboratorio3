package co.edu.javeriana.as.boot.spring.personapp.mongo.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.EstudiosMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;

@Component
public class EstudiosMongoMapper {
    @Autowired
    ProfesionMongoMapper profesionMapper;

    public Study toEstudiosFromEstudiosEntity(EstudiosMongoEntity estudiosEntity){
        Study study = new Study();
        study.setFecha(estudiosEntity.getFecha());
        study.setUniver(estudiosEntity.getUniver());
        study.setProfession(profesionMapper.toProfesionFromProfesionEntity(estudiosEntity.getProfesion()));
        return study;
    }
    
    public EstudiosMongoEntity toEstudiosEntityFromEstudios(Study study, PersonaMongoEntity personaEntity) {
        EstudiosMongoEntity estudiosEntity = new EstudiosMongoEntity();
        estudiosEntity.setFecha(study.getFecha());
        estudiosEntity.setUniver(study.getUniver());
        estudiosEntity.setProfesion(profesionMapper.toProfesionEntityFromProfesion(study.getProfession()));
        estudiosEntity.getProfesion();
        return estudiosEntity;
    }

    public List<Study> toListEstudiosFromListEstudiosEntity(List<EstudiosMongoEntity> estudiosEntities) {
        List<Study> estudios = new ArrayList<>();
        for (EstudiosMongoEntity estudiosEntity : estudiosEntities) {
            estudios.add(toEstudiosFromEstudiosEntity(estudiosEntity));
        }
        return estudios;
    }

    public List<EstudiosMongoEntity> toListEstudiosEntityFromListEstudios(List<Study> estudiosses, PersonaMongoEntity personaEntity) {
        List<EstudiosMongoEntity> estudiosEntities = new ArrayList<>();
        for(Study study : estudiosses) {
            estudiosEntities.add(toEstudiosEntityFromEstudios(study, personaEntity));
        }
        return estudiosEntities;
    }
}
