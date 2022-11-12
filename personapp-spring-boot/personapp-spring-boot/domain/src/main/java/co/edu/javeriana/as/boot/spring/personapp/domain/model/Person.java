package co.edu.javeriana.as.boot.spring.personapp.domain.model;

import lombok.Data;

@Data
public class Person {
    private Integer cc;
    private String name;
    private String last_name;
    private String gender;
    private Integer age;

}
