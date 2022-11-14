/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import java.util.List;


public interface PersonPortOut {
    Person findById(Integer cc);

    boolean create(Person persona);

    boolean edit(Integer cc, Person persona);

    boolean remove(Integer cc);

    Integer count();

    List<Person> findAll();

}
