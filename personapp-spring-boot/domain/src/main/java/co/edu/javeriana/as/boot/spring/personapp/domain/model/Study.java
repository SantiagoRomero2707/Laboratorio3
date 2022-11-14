package co.edu.javeriana.as.boot.spring.personapp.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Study {
    private LocalDate fecha;
    private String univer;
    private Profession profession;
}
