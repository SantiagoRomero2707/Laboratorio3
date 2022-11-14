package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosPK;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonEntity;


@Component
public class StudyMapper {

    @Autowired
    ProfessionMapper professionMapper;

    public Study toEstudiosFromEstudiosEntity(EstudiosEntity estudiosEntity){
        Study study = new Study();
        study.setFecha(estudiosEntity.getFecha());
        study.setUniver(estudiosEntity.getUniver());
        study.setProfession(professionMapper.toProfesionFromProfesionEntity(estudiosEntity.getProfesion()));
        return study;
    }
    
    public EstudiosEntity toEstudiosEntityFromEstudios(Study study, PersonEntity personEntity) {
        EstudiosPK estudiosPK = new EstudiosPK();
        estudiosPK.setCcPer(personEntity.getCc());
        estudiosPK.setIdProf(study.getProfession().getId());
        EstudiosEntity estudiosEntity = new EstudiosEntity();
        estudiosEntity.setEstudiosPK(estudiosPK);
        estudiosEntity.setFecha(study.getFecha());
        estudiosEntity.setUniver(study.getUniver());
        estudiosEntity.setProfesion(professionMapper.toProfesionEntityFromProfesion(study.getProfession()));
        estudiosEntity.getProfesion();
        estudiosEntity.setPersona(personEntity);
        return estudiosEntity;
    }

    public List<Study> toListEstudiosFromListEstudiosEntity(List<EstudiosEntity> estudiosEntities) {
        List<Study> estudios = new ArrayList<>();
        for (EstudiosEntity estudiosEntity : estudiosEntities) {
            estudios.add(toEstudiosFromEstudiosEntity(estudiosEntity));
        }
        return estudios;
    }

    public List<EstudiosEntity> toListEstudiosEntityFromListEstudios(List<Study> estudiosses, PersonEntity personEntity) {
        List<EstudiosEntity> estudiosEntities = new ArrayList<>();
        for(Study study : estudiosses) {
            estudiosEntities.add(toEstudiosEntityFromEstudios(study, personEntity));
        }
        return estudiosEntities;
    }
}
