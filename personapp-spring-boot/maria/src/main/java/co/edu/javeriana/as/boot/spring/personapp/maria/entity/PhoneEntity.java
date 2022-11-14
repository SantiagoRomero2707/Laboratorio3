package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(catalog = "persona_db", schema = "", name = "telefono")
@NamedQueries({
    @NamedQuery(name = "PhoneEntity.findAll", query = "SELECT t FROM PhoneEntity t")
    , @NamedQuery(name = "PhoneEntity.findByNum", query = "SELECT t FROM PhoneEntity t WHERE t.num = :num")
    , @NamedQuery(name = "PhoneEntity.findByOper", query = "SELECT t FROM PhoneEntity t WHERE t.oper = :oper")})
@Data
public class PhoneEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String num;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String oper;
    @JoinColumn(name = "duenio", referencedColumnName = "cc", nullable = false)
    @ManyToOne(optional = false)
    private PersonEntity duenio;
}
