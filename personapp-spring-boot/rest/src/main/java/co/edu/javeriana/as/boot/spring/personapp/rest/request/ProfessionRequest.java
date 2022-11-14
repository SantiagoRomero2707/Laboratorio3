package co.edu.javeriana.as.boot.spring.personapp.rest.request;

import lombok.Data;

@Data
public class ProfessionRequest {
    
    private Integer id;
    private String nom;
    private String des;
}
