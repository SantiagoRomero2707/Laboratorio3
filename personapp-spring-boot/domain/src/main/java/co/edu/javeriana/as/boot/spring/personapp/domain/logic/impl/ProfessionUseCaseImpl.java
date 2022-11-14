package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.ProfessionUseCase;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.ProfessionPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.ProfessionPortOutMongo;

@Service
public class ProfessionUseCaseImpl implements ProfessionUseCase {

    @Autowired
    private ProfessionPortOutMongo professionPortOutMongo;

    @Autowired
    private ProfessionPortOutMaria professionPortOutMaria;

    @Override
    public Profession findById(Integer id, Integer bandera) {
        switch (bandera) {
            case 0:
                return professionPortOutMongo.findById(id);
            case 1:
                return professionPortOutMaria.findById(id);
            default:
                Profession mongo = professionPortOutMaria.findById(id);
                return mongo;  
        }
    }

    @Override
    public boolean create(Profession profession, Integer bandera) {
        switch (bandera) {
            case 0:
                return professionPortOutMongo.create(profession);
            case 1:
                return professionPortOutMaria.create(profession);
            default:
                Boolean mongo = professionPortOutMongo.create(profession);
                Boolean maria = professionPortOutMaria.create(profession);
                if(mongo && maria) {
                    return true;
                } else {

                }
                break;
        }
        return false;
    }

    @Override
    public boolean edit(Integer id, Profession profession, Integer bandera) {
        switch (bandera) {
            case 0:
                return professionPortOutMongo.edit(id, profession);
            case 1:
                return professionPortOutMaria.edit(id, profession);
            default:
                Boolean mongo = professionPortOutMongo.edit(id, profession);
                Boolean maria = professionPortOutMaria.edit(id, profession);
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
                return professionPortOutMongo.remove(id);
            case 1:
                return professionPortOutMaria.remove(id);
            default:
                Boolean mongo = professionPortOutMongo.remove(id);
                Boolean maria = professionPortOutMaria.remove(id);
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
                return professionPortOutMongo.count();
            case 1:
                return professionPortOutMaria.count();
            default:
                Integer mongo = professionPortOutMongo.count();
                Integer maria = professionPortOutMaria.count();
                if(mongo == maria) {
                    return mongo;
                } else {
                    
                }
                break;
        }
        return 0;
    }

    @Override
    public List<Profession> findAll(Integer bandera) {
        switch (bandera) {
            case 0:
                return professionPortOutMongo.findAll();
            case 1:
                return professionPortOutMaria.findAll();
            default:
                return professionPortOutMaria.findAll();
        } 
    }
}
