/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="telefono", catalog = "persona_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM TelefonoEntity t"),
    @NamedQuery(name = "Telefono.findByNum", query = "SELECT t FROM TelefonoEntity t WHERE t.num = :num"),
    @NamedQuery(name = "Telefono.findByOper", query = "SELECT t FROM TelefonoEntity t WHERE t.oper = :oper")})
@Data
public class TelefonoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, length = 15)
    private String num;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, length = 45)
    private String oper;
    @JoinColumn(name = "duenio", referencedColumnName = "cc", nullable = false)
    @ManyToOne(optional = false)
    private PersonaEntity duenio;

    public TelefonoEntity() {
    }

}
