package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonUseCase;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.PersonPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.PersonPortOutMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonLogicImpl implements PersonUseCase {

    @Autowired
    private PersonPortOutMongo personPortOutMongo;

    @Autowired
    private PersonPortOutMaria personPortOutMaria;


    @Override
    public String create(Person person, Integer flag) {
        // 0-> Mongo
        // 1-> MariaDB
        switch (flag){
            case 0:
                return personPortOutMongo.create(person);
            case 1:
                return personPortOutMaria.create(person);
            default:
                String mongo = personPortOutMongo.create(person);
                String maria = personPortOutMaria.create(person);
                if(mongo.equals(maria) && mongo.equals("se creó")){
                    return mongo;
                }
                else{
                    // validar cuándo las dos falló o alguna de las dos falló
                    return "Falta";

                }
        }
    }

    @Override
    public String edit(Integer id, Person person, Integer flag) {
        return null;
    }

    @Override
    public Boolean remove(Integer id, Integer flag) {
        return null;
    }

    @Override
    public Person findByID(Integer id, Integer flag) {
        return null;
    }

    @Override
    public int count(Integer flag) {
        return 0;
    }

    @Override
    public List<Person> findAll(Integer flag) {
        return null;
    }
}
