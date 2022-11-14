/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonUseCase;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.PersonPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.PersonPortOutMongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonUseCaseImpl implements PersonUseCase {

    @Autowired
    private PersonPortOutMongo personPortOutMongo;

    @Autowired
    private PersonPortOutMaria personPortOutMaria;

    @Override
    public Person findById(Integer cc, Integer bandera) {
        switch (bandera) {
            case 0:
                return personPortOutMongo.findById(cc);
            case 1:
                return personPortOutMaria.findById(cc);
            default:
                Person mongo = personPortOutMongo.findById(cc);
                Person maria = personPortOutMaria.findById(cc);
                if(mongo.getCc() ==  maria.getCc()){
                    return mongo;
                }
            break;
        }
        return null;
    }

    @Override
    public boolean create(Person persona, Integer bandera) {
        switch (bandera) {
            case 0:
                return personPortOutMongo.create(persona);
            case 1:
                return personPortOutMaria.create(persona);
        
            default:
                Boolean mongo = personPortOutMongo.create(persona);
                Boolean maria = personPortOutMaria.create(persona);
                if(mongo ==  maria && mongo){
                    return mongo;
                }else{

                }
            break;
        }
        return false;
    }

    @Override
    public boolean edit(Integer cc, Person persona, Integer bandera) {
        switch (bandera) {
            case 0:
                return personPortOutMongo.edit(cc,persona);
            case 1:
                return personPortOutMaria.edit(cc,persona);
        
            default:
                Boolean mongo = personPortOutMongo.edit(cc,persona);
                Boolean maria = personPortOutMaria.edit(cc,persona);
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
                return personPortOutMongo.remove(cc);
            case 1:
                return personPortOutMaria.remove(cc);
        
            default:
                Boolean mongo = personPortOutMongo.remove(cc);
                Boolean maria = personPortOutMaria.remove(cc);
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
                return personPortOutMongo.count();
            case 1:
                return personPortOutMaria.count();
        
            default:
                Integer mongo = personPortOutMongo.count();
                Integer maria = personPortOutMaria.count();
                if(mongo ==  maria){
                    return mongo;
                }
            break;
        }
        return 0;
    }

    @Override
    public List<Person> findAll(Integer bandera) {
        switch (bandera) {
            case 0:
                return personPortOutMongo.findAll();
            case 1:
                return personPortOutMaria.findAll();
        
            default:
                return personPortOutMaria.findAll();
        }
    }
}
