/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author santy
 */
@Entity
@Table(name="persona", catalog = "persona_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "PersonaEntity.findAll", query = "SELECT p FROM PersonaEntity p"),
    @NamedQuery(name = "PersonaEntity.findByCc", query = "SELECT p FROM PersonaEntity p WHERE p.cc = :cc"),
    @NamedQuery(name = "PersonaEntity.findByNombre", query = "SELECT p FROM PersonaEntity p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PersonaEntity.findByApellido", query = "SELECT p FROM PersonaEntity p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "PersonaEntity.findByGenero", query = "SELECT p FROM PersonaEntity p WHERE p.genero = :genero"),
    @NamedQuery(name = "PersonaEntity.findByEdad", query = "SELECT p FROM PersonaEntity p WHERE p.edad = :edad")})

@Data
public class PersonaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer cc;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, length = 45)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, length = 1)
    private String genero;
    private Integer edad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duenio")
    private Collection<TelefonoEntity> telefonoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<EstudiosEntity> estudiosCollection;

}
