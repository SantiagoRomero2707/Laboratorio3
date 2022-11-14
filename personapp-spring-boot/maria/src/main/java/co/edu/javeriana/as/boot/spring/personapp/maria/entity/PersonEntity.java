/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Data;

/**
 *
 * @author aasanchez
 */

@Entity
@Table(name = "persona",catalog = "persona_db",schema = "")
@NamedQueries({
    @NamedQuery(name = "PersonEntity.findAll", query = "SELECT p FROM PersonEntity p")
    , @NamedQuery(name = "PersonEntity.findByCc", query = "SELECT p FROM PersonEntity p WHERE p.cc = :cc")
    , @NamedQuery(name = "PersonEntity.findByNombre", query = "SELECT p FROM PersonEntity p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PersonEntity.findByApellido", query = "SELECT p FROM PersonEntity p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "PersonEntity.findByGenero", query = "SELECT p FROM PersonEntity p WHERE p.genero = :genero")
    , @NamedQuery(name = "PersonEntity.findByEdad", query = "SELECT p FROM PersonEntity p WHERE p.edad = :edad")})
@Data
public class PersonEntity implements Serializable{
    @Id
    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private Integer edad;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneEntity> telefonos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EstudiosEntity> estudios;

}
