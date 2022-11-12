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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author santy
 */
@Entity
@Table(name="profesion",catalog = "persona_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM ProfesionEntity p"),
    @NamedQuery(name = "Profesion.findById", query = "SELECT p FROM ProfesionEntity p WHERE p.id = :id"),
    @NamedQuery(name = "Profesion.findByNom", query = "SELECT p FROM ProfesionEntity p WHERE p.nom = :nom")})
@Data
public class ProfesionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, length = 90)
    private String nom;
    @Lob
    @Column(length = 65535)
    private String des;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesion")
    private Collection<EstudiosEntity> estudiosCollection;

}
