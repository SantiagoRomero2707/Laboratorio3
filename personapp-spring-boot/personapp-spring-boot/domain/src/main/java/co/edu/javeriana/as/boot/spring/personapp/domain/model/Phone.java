package co.edu.javeriana.as.boot.spring.personapp.domain.model;

import lombok.Data;

@Data
public class Phone {
    private String number ;
    private String provider;
    private Person owner;

}
