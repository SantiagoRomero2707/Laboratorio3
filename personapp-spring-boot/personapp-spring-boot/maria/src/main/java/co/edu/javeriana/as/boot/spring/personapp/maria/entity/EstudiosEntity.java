/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author santy
 */
@Entity
@Table(name="estudios", catalog = "persona_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Estudios.findAll", query = "SELECT e FROM EstudiosEntity e"),
    @NamedQuery(name = "Estudios.findByIdProf", query = "SELECT e FROM EstudiosEntity e WHERE e.estudiosPK.idProf = :idProf"),
    @NamedQuery(name = "Estudios.findByCcPer", query = "SELECT e FROM EstudiosEntity e WHERE e.estudiosPK.ccPer = :ccPer"),
    @NamedQuery(name = "Estudios.findByFecha", query = "SELECT e FROM EstudiosEntity e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Estudios.findByUniver", query = "SELECT e FROM EstudiosEntity e WHERE e.univer = :univer")})
@Data
public class EstudiosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiosPK estudiosPK;
    @Column(columnDefinition = "DATE")private LocalDate date;
    private LocalDate fecha;
    @Column(length = 50)
    private String univer;
    @JoinColumn(name = "cc_per", referencedColumnName = "cc", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PersonaEntity persona;
    @JoinColumn(name = "id_prof", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProfesionEntity profesion;

}
