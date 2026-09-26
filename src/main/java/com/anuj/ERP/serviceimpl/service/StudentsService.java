package com.anuj.ERP.serviceimpl.service;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.StudentResponseDTO;
import com.anuj.ERP.model.Courses;
import com.anuj.ERP.model.Students;
import com.anuj.ERP.requestDTO.StudentCreateDTO;
import com.anuj.ERP.requestDTO.StudentsUpdateDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentsService {

    public StudentResponseDTO addStudent(StudentCreateDTO student);
    public StudentResponseDTO updateStudent(long uid, StudentsUpdateDTO studentsUpdateDTO);
    public StudentResponseDTO getStudentByUID(long uid);
    public List<StudentResponseDTO> getAllStudents(Degree degree, Year year);
    public String deleteStudent(long uid);
    public String deleteAllStudents(Degree degree, Year year);
}