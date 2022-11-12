package co.edu.javeriana.as.boot.spring.personapp.domain.model;

import lombok.Data;

import java.util.List;
@Data
public class Profession {
    private Integer id;
    private String name;
    private String description;
    private List<Study> studies;
}
