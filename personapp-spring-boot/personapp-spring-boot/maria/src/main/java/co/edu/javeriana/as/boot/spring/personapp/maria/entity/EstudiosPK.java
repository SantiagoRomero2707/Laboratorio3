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
import javax.persistence.Embeddable;

/**
 *
 * @author santy
 */
@Embeddable
@Data
public class EstudiosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prof", nullable = false)
    private int idProf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cc_per", nullable = false)
    private int ccPer;

}
