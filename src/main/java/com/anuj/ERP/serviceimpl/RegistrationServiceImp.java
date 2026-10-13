package com.anuj.ERP.serviceimpl;

import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.RegistrationResponseDTO;
import com.anuj.ERP.exception.ResourceNotFoundException;
import com.anuj.ERP.mapper.RegistrationMapper;
import com.anuj.ERP.model.Courses;
import com.anuj.ERP.model.Registration;
import com.anuj.ERP.model.Students;
import com.anuj.ERP.repository.CoursesRepository;
import com.anuj.ERP.repository.RegistrationRepository;
import com.anuj.ERP.repository.StudentsRepository;
import com.anuj.ERP.requestDTO.RegistrationCreateDTO;
import com.anuj.ERP.serviceimpl.service.RegistrationService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class RegistrationServiceImp implements RegistrationService {

    private final StudentsRepository studentsRepository;
    private final RegistrationRepository registrationRepository;
    private final CoursesRepository coursesRepository;
    private final RegistrationMapper registrationMapper;

    @Override
    public RegistrationResponseDTO newRegistration(RegistrationCreateDTO registrationCreateDTO){
        Registration registration = new Registration();
        Students students = studentsRepository.findById(registrationCreateDTO.getUid())
                 .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        List<Courses> courses = new ArrayList<>();
        for(Long x : registrationCreateDTO.getCid()){
            courses.add(coursesRepository.findById(x). orElseThrow(() -> new ResourceNotFoundException("Course with id : "+ x + " not found")));
        }
        registration.setRegistrationType(registrationCreateDTO.getRegistrationType());
        registration.setFees(registrationCreateDTO.getFees());
        registration.setCourses(courses);
        registration.setStudents(students);

        registrationRepository.save(registration);
        return registrationMapper.toResponse(registration);
    }

    @Override
    public RegistrationResponseDTO getRegistration(long uid, Year year) {
        Students students = studentsRepository.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("Student with UID" + uid + "not found"));

        Registration registration = registrationRepository.findByStudentsAndYear(students,year)
                .orElseThrow(() -> new ResourceNotFoundException("Student's Registration not found!"));

        return registrationMapper.toResponse(registration);
    }
}
