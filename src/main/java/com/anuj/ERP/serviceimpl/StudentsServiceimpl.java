package com.anuj.ERP.serviceimpl;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.StudentResponseDTO;
import com.anuj.ERP.mapper.StudentMapper;
import com.anuj.ERP.model.Courses;
import com.anuj.ERP.model.Students;
import com.anuj.ERP.repository.StudentsRepository;
import com.anuj.ERP.requestDTO.StudentCreateDTO;
import com.anuj.ERP.requestDTO.StudentsUpdateDTO;
import com.anuj.ERP.serviceimpl.service.StudentsService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class StudentsServiceimpl implements StudentsService{

    private final StudentsRepository studentsRepository;
    private final StudentMapper studentMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public StudentResponseDTO addStudent(StudentCreateDTO studentCreateDTO) {
        if(studentsRepository.existsById(studentCreateDTO.getUid())) throw new RuntimeException("Uid is already in use");
        if(studentsRepository.existsByContact(studentCreateDTO.getContact())) throw new RuntimeException("Contact is already in use");
        if(studentsRepository.existsByEmail(studentCreateDTO.getEmail())) throw new RuntimeException("Email is already in use");

        Students students = new Students();
        students.setUid(studentCreateDTO.getUid());
        students.setName(studentCreateDTO.getName());
        students.setPassword(passwordEncoder.encode(studentCreateDTO.getPassword()));
        students.setContact(studentCreateDTO.getContact());
        students.setEmail(studentCreateDTO.getEmail());

        return studentMapper.toResponse(studentsRepository.save(students));
    }

    @Override
    public StudentResponseDTO updateStudent(long uid, StudentsUpdateDTO studentsUpdateDTO){
        Students students = studentsRepository.findById(uid).orElseThrow(()-> new RuntimeException("Student not found"));

        if(studentsUpdateDTO.getName() != null){
            students.setName(studentsUpdateDTO.getName());
        }
        if(studentsUpdateDTO.getBirthDate() != null){
            students.setBirthDate(studentsUpdateDTO.getBirthDate());
        }
        if(studentsUpdateDTO.getDegree() != null){
            students.setDegree(studentsUpdateDTO.getDegree());
        }
        if(studentsUpdateDTO.getYear() != null){
            students.setYear(studentsUpdateDTO.getYear());
        }
        if(studentsUpdateDTO.getPassword() != null){
            students.setPassword(passwordEncoder.encode(studentsUpdateDTO.getPassword()));
        }
        if(studentsUpdateDTO.getContact() != null){
            students.setContact(studentsUpdateDTO.getContact());
        }

        return studentMapper.toResponse(studentsRepository.save(students));
    }

    @Override
    public StudentResponseDTO getStudentByUID(long uid) {
            Students students = studentsRepository.findById(uid).orElseThrow(()-> new RuntimeException("Student not found"));
        return studentMapper.toResponse(students);
    }

    public List<StudentResponseDTO> getAllStudents( Degree degree,Year year){
        List<Students> students;
        if(degree != null && year != null ){
        students = studentsRepository.findByDegreeAndYear(degree,year);
            return studentMapper.toResponseList(students);
        }
        else if(degree != null ){
        students = studentsRepository.findByDegree(degree);
            return studentMapper.toResponseList(students);
        }
        else if(year != null){
        students = studentsRepository.findByYear(year);
            return studentMapper.toResponseList(students);
        }else{
        students = studentsRepository.findAll();
            return studentMapper.toResponseList(students);
        }
    }

    public String deleteStudent(long uid){
        Students students = studentsRepository.findById(uid)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentsRepository.delete(students);
        return "Student successfully deleted";
    }

    public String  deleteAllStudents( Degree degree,Year year){
        List<Students> students = new ArrayList<>();
        if(degree != null && year != null ){
            students = studentsRepository.findByDegreeAndYear(degree,year);
        }
        else if(degree != null ){
            students = studentsRepository.findByDegree(degree);
        }
        else if(year != null) {
            students = studentsRepository.findByYear(year);
        }
        studentsRepository.deleteAll(students);
        return "Students deleted successfully";
    }
}
