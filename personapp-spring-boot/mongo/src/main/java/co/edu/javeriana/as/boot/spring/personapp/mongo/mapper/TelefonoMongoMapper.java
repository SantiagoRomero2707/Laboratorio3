package co.edu.javeriana.as.boot.spring.personapp.mongo.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.TelefonoMongoEntity;

@Component
public class TelefonoMongoMapper {
    public TelefonoMongoEntity toTelefonoEntityFromTelefono(Phone phone, PersonaMongoEntity personaEntity) {
        TelefonoMongoEntity telefonoEntity = new TelefonoMongoEntity();
        telefonoEntity.setNum(phone.getNum());
        telefonoEntity.setOper(phone.getOper());
        return telefonoEntity;
    }

    public Phone toTelefonoFromTelefonoEntity(TelefonoMongoEntity telefonoEntity) {
        Phone phone = new Phone();
        phone.setNum(telefonoEntity.getNum());
        phone.setOper(telefonoEntity.getOper());
        return phone;
    }
    
    public List<TelefonoMongoEntity> toListTelefonoEntityFromListTelefono(List<Phone> phones, PersonaMongoEntity personaEntity) {
        List<TelefonoMongoEntity> telefonoEntities = new ArrayList<>();
        for(Phone phone : phones) {
            telefonoEntities.add(toTelefonoEntityFromTelefono(phone, personaEntity));
        }
        return telefonoEntities;
    }

    public List<Phone> toListTelefonoFromListTelefonoEntity(List<TelefonoMongoEntity> telefonoEntities) {
        List<Phone> phones = new ArrayList<>();
        for(TelefonoMongoEntity telefonoEntity : telefonoEntities) {
            phones.add(toTelefonoFromTelefonoEntity(telefonoEntity));
        }
        return phones;
    }
}
