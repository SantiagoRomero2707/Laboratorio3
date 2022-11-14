package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.StudyUseCase;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.StudyPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.StudyPortOutMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudyUseCaseImpl implements StudyUseCase {

    @Autowired
    private StudyPortOutMongo studyPortOutMongo;

    @Autowired
    private StudyPortOutMaria studyPortOutMaria;

    @Override
    public Study findById(Integer id, Integer bandera) {
        switch (bandera) {
            case 0:
                return studyPortOutMongo.findById(id);
            case 1:
                return studyPortOutMaria.findById(id);
            default:
                Study mongo = studyPortOutMaria.findById(id);
                return mongo;
        }
    }

    @Override
    public boolean create(Study study, Integer bandera) {
        switch (bandera) {
            case 0:
                return studyPortOutMongo.create(study);
            case 1:
                return studyPortOutMaria.create(study);
            default:
                Boolean mongo = studyPortOutMongo.create(study);
                Boolean maria = studyPortOutMaria.create(study);
                if(mongo && maria) {
                    return true;
                } else {

                }
                break;
        }
        return false;
    }

    @Override
    public boolean edit(Integer id, Study study, Integer bandera) {
        switch (bandera) {
            case 0:
                return studyPortOutMongo.edit(id, study);
            case 1:
                return studyPortOutMaria.edit(id, study);
            default:
                Boolean mongo = studyPortOutMongo.edit(id, study);
                Boolean maria = studyPortOutMaria.edit(id, study);
                if(mongo && maria) {
                    return true;
                } else {

                }
                break;
        }
        return false;
    }

    @Override
    public boolean remove(Integer id, Integer bandera) {
        switch (bandera) {
            case 0:
                return studyPortOutMongo.remove(id);
            case 1:
                return studyPortOutMaria.remove(id);
            default:
                Boolean mongo = studyPortOutMongo.remove(id);
                Boolean maria = studyPortOutMaria.remove(id);
                if(mongo && maria) {
                    return true;
                } else {

                }
                break;
        }
        return false;
    }

    @Override
    public Integer count(Integer bandera) {
        switch (bandera) {
            case 0:
                return studyPortOutMongo.count();
            case 1:
                return studyPortOutMaria.count();
            default:
                Integer mongo = studyPortOutMongo.count();
                Integer maria = studyPortOutMaria.count();
                if(mongo == maria) {
                    return mongo;
                } else {

                }
                break;
        }
        return 0;
    }

    @Override
    public List<Study> findAll(Integer bandera) {
        switch (bandera) {
            case 0:
                return studyPortOutMongo.findAll();
            case 1:
                return studyPortOutMaria.findAll();
            default:
                return studyPortOutMaria.findAll();
        }
    }
}
