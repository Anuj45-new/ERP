package com.anuj.ERP.mapper;

import com.anuj.ERP.ResponseDTO.StudentResponseDTO;
import com.anuj.ERP.model.Students;
import com.anuj.ERP.requestDTO.StudentCreateDTO;
import com.anuj.ERP.requestDTO.StudentsUpdateDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class StudentMapper{

    public StudentResponseDTO toResponse(Students students) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setBirthDate(students.getBirthDate());
        studentResponseDTO.setDegree(students.getDegree());
        studentResponseDTO.setYear(students.getYear());
        studentResponseDTO.setName(students.getName());
        studentResponseDTO.setEmail(students.getEmail());
        studentResponseDTO.setUid(students.getUid());
        studentResponseDTO.setContact(students.getContact());
        return studentResponseDTO;
    }

    public List<StudentResponseDTO> toResponseList(List<Students> students){
        List<StudentResponseDTO> responseList = new ArrayList<StudentResponseDTO>();

        for(Students x: students){
            responseList.add(toResponse(x));
        }
        return responseList;
    }
}
