package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(catalog = "persona_db", schema = "", name = "profesion")
@NamedQueries({
    @NamedQuery(name = "ProfessionEntity.findAll", query = "SELECT p FROM ProfessionEntity p")
    , @NamedQuery(name = "ProfessionEntity.findById", query = "SELECT p FROM ProfessionEntity p WHERE p.id = :id")
    , @NamedQuery(name = "ProfessionEntity.findByNom", query = "SELECT p FROM ProfessionEntity p WHERE p.nom = :nom")})
@Data
public class ProfessionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 90, unique = true)
    private String nom;
    @Lob
    @Column(length = 65535)
    private String des;
}
