package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PhoneEntity;

@Component
public class PhoneMapper {
    public PhoneEntity toTelefonoEntityFromTelefono(Phone phone, PersonEntity personEntity) {
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setNum(phone.getNum());
        phoneEntity.setOper(phone.getOper());
        phoneEntity.setDuenio(personEntity);
        return phoneEntity;
    }

    public Phone toTelefonoFromTelefonoEntity(PhoneEntity phoneEntity) {
        Phone phone = new Phone();
        phone.setNum(phoneEntity.getNum());
        phone.setOper(phoneEntity.getOper());
        return phone;
    }
    
    public List<PhoneEntity> toListTelefonoEntityFromListTelefono(List<Phone> phones, PersonEntity personEntity) {
        List<PhoneEntity> telefonoEntities = new ArrayList<>();
        for(Phone phone : phones) {
            telefonoEntities.add(toTelefonoEntityFromTelefono(phone, personEntity));
        }
        return telefonoEntities;
    }

    public List<Phone> toListTelefonoFromListTelefonoEntity(List<PhoneEntity> telefonoEntities) {
        List<Phone> phones = new ArrayList<>();
        for(PhoneEntity phoneEntity : telefonoEntities) {
            phones.add(toTelefonoFromTelefonoEntity(phoneEntity));
        }
        return phones;
    }
}
