package co.edu.javeriana.as.boot.spring.personapp.domain.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Study {
    private Profession profession;
    private Person person;
    private Date date;
    private String university;
    private List<Study> studies;

}
