package co.edu.javeriana.as.boot.spring.personapp.rest.request;

import lombok.Data;

@Data
public class StudyRequest {
    private String fecha;
    private String univer;
    private ProfessionRequest profesion;
}
