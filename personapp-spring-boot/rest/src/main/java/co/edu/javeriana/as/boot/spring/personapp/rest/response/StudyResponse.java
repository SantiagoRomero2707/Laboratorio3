package co.edu.javeriana.as.boot.spring.personapp.rest.response;

import lombok.Data;

@Data
public class StudyResponse {
    private String fecha;
    private String univer;
    private ProfessionResponse profesion;
}
