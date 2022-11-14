package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PhoneUseCase;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.PhonePortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.PhonePortOutMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneUseCaseImpl implements PhoneUseCase {
    @Autowired
    private PhonePortOutMongo phonePortOutMongo;

    @Autowired
    private PhonePortOutMaria phonePortOutMaria;

    @Override
    public Phone findById(Integer cc, Integer bandera) {
        switch (bandera) {
            case 0:
                return phonePortOutMongo.findById(cc);
            case 1:
                return phonePortOutMaria.findById(cc);
            default:
                Phone mongo = phonePortOutMongo.findById(cc);
                Phone maria = phonePortOutMaria.findById(cc);
                if(mongo.getNum() ==  maria.getNum()){
                    return mongo;
                }
                break;
        }
        return null;
    }

    @Override
    public boolean create(Phone phone, Integer bandera) {
        switch (bandera) {
            case 0:
                return phonePortOutMongo.create(phone);
            case 1:
                return phonePortOutMaria.create(phone);

            default:
                Boolean mongo = phonePortOutMongo.create(phone);
                Boolean maria = phonePortOutMaria.create(phone);
                if(mongo ==  maria && mongo){
                    return mongo;
                }else{

                }
                break;
        }
        return false;
    }

    @Override
    public boolean edit(Integer cc, Phone phone, Integer bandera) {
        switch (bandera) {
            case 0:
                return phonePortOutMongo.edit(cc,phone);
            case 1:
                return phonePortOutMaria.edit(cc,phone);

            default:
                Boolean mongo = phonePortOutMongo.edit(cc,phone);
                Boolean maria = phonePortOutMaria.edit(cc,phone);
                if(maria && mongo){
                    return mongo;
                }
                break;
        }
        return false;
    }

    @Override
    public boolean remove(Integer cc, Integer bandera) {
        switch (bandera) {
            case 0:
                return phonePortOutMongo.remove(cc);
            case 1:
                return phonePortOutMaria.remove(cc);

            default:
                Boolean mongo = phonePortOutMongo.remove(cc);
                Boolean maria = phonePortOutMaria.remove(cc);
                if(mongo ==  maria && mongo){
                    return mongo;
                }else{

                }
                break;
        }
        return false;
    }

    @Override
    public Integer count(Integer bandera) {
        switch (bandera) {
            case 0:
                return phonePortOutMongo.count();
            case 1:
                return phonePortOutMaria.count();

            default:
                Integer mongo = phonePortOutMongo.count();
                Integer maria = phonePortOutMaria.count();
                if(mongo ==  maria){
                    return mongo;
                }
                break;
        }
        return 0;
    }

    @Override
    public List<Phone> findAll(Integer bandera) {
        switch (bandera) {
            case 0:
                return phonePortOutMongo.findAll();
            case 1:
                return phonePortOutMaria.findAll();

            default:
                return phonePortOutMaria.findAll();
        }
    }
}
