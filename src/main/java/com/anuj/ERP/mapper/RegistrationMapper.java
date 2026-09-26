package com.anuj.ERP.mapper;

import com.anuj.ERP.ResponseDTO.RegistrationResponseDTO;
import com.anuj.ERP.model.Courses;
import com.anuj.ERP.model.Registration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter @Setter
public class RegistrationMapper {

    public RegistrationResponseDTO toResponse(Registration registration){
        RegistrationResponseDTO registrationResponseDTO = new RegistrationResponseDTO();

        registrationResponseDTO.setId(registration.getId());
        registrationResponseDTO.setSuid((registration.getStudents()).getUid());
        registrationResponseDTO.setSname((registration.getStudents()).getName());
        registrationResponseDTO.setFees(registration.getFees());
        registrationResponseDTO.setRegistrationType(registration.getRegistrationType());
        registrationResponseDTO.setTime(registration.getTime());
        registrationResponseDTO.setYear(registration.getYear());

        List<Courses> courses = registration.getCourses();
        List<Long> ids = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for ( Courses c : courses) {
            ids.add(c.getId());
            names.add(c.getName());
        }
        registrationResponseDTO.setCname(names);
        registrationResponseDTO.setCid(ids);

        return registrationResponseDTO;
    }
}
