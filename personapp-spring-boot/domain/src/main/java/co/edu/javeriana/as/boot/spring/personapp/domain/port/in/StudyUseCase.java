/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Person;
import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;

import java.util.List;


public interface StudyUseCase {

    Study findById(Integer cc, Integer flag);

    boolean create(Study study, Integer flag);

    boolean edit(Integer cc, Study study, Integer flag);

    boolean remove(Integer cc, Integer flag);

    Integer count(Integer flag);

    List<Study> findAll(Integer flag);
}
