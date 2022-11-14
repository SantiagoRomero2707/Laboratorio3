package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profession;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.rest.request.ProfessionRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.ProfessionResponse;

@Component
public class ProfessionRestMapper {

    public List<ProfessionResponse> fromListProfesionesToListProfesionesResponse(List<Profession> profesiones) {
        List<ProfessionResponse> personaResponses = new ArrayList<ProfessionResponse>();
        for( Profession profession : profesiones){
            ProfessionResponse profesionPostResponse = new ProfessionResponse();
            profesionPostResponse.setId(profession.getId());
            profesionPostResponse.setNom(profession.getNom());
            profesionPostResponse.setDes(profession.getDes());
            personaResponses.add(profesionPostResponse);
        }
        return personaResponses;
    }

    public Profession fromProfesionRequestToProfesion(ProfessionRequest professionRequest) {
        if (professionRequest == null) {
            return null;
        }
        Profession profession = new Profession();
        profession.setId(professionRequest.getId());
        profession.setNom(professionRequest.getNom());
        profession.setDes(professionRequest.getDes());
        return profession;
    }

    public ProfessionResponse fromProfesionToProfesionResponse(Profession profession) {
        if (profession == null) {
            return null;
        }
        ProfessionResponse professionResponse = new ProfessionResponse();
        professionResponse.setId(profession.getId());
        professionResponse.setNom(profession.getNom());
        professionResponse.setDes(profession.getDes());
        return professionResponse;
    }
    
}
