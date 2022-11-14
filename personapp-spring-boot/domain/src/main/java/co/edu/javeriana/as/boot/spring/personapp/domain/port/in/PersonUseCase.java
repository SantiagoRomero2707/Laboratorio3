/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;


public interface PersonUseCase {

    Person findById(Integer cc, Integer flag);

    boolean create(Person persona, Integer flag);

    boolean edit(Integer cc, Person persona, Integer flag);

    boolean remove(Integer cc, Integer flag);

    Integer count(Integer flag);

    List<Person> findAll(Integer flag);
}
