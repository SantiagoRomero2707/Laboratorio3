package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Study;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.StudyRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.StudyResponse;

@Component
public class StudyRestMapper {

    @Autowired
    ProfessionRestMapper professionRestMapper;

    public Study fromEstudiosRequestToEstudios(StudyRequest studyRequest) {
        if (studyRequest == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Study study = new Study();
        study.setFecha(LocalDate.parse(studyRequest.getFecha(), formatter));
        study.setUniver(studyRequest.getUniver());
        study.setProfession(professionRestMapper.fromProfesionRequestToProfesion(studyRequest.getProfesion()));
        return study;
    }

    public StudyResponse fromEstudiosToEstudiosResponse(Study study) {
        if (study == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StudyResponse studyResponse = new StudyResponse();
        studyResponse.setFecha(study.getFecha().format(formatter));
        studyResponse.setUniver(study.getUniver());
        studyResponse.setProfesion(professionRestMapper.fromProfesionToProfesionResponse(study.getProfession()));
        return studyResponse;
    }

    public List<Study> fromListEstudiosRequestToListEstudios(List<StudyRequest> studyRequests) {
        List<Study> estudios = new ArrayList<>();
        for (StudyRequest studyRequest : studyRequests) {
            estudios.add(fromEstudiosRequestToEstudios(studyRequest));
        }
        return estudios;
    }

    public List<StudyResponse> fromListEstudiosToListEstudiosResponse(List<Study> estudiosses) {
        List<StudyResponse> studyRespons = new ArrayList<>();
        for (Study study : estudiosses) {
            studyRespons.add(fromEstudiosToEstudiosResponse(study));
        }
        return studyRespons;
    }
}
