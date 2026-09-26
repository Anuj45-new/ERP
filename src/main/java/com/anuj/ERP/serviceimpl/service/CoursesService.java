package com.anuj.ERP.serviceimpl.service;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.CourseResponseDTO;
import com.anuj.ERP.requestDTO.CourseCreateDTO;
import com.anuj.ERP.requestDTO.CourseUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoursesService {

    public CourseResponseDTO createCourse(CourseCreateDTO courseCreateDTO);
    public CourseResponseDTO findCourse(long id);
    public String deleteCourses(Degree degree, Year year);
    public String deleteCourse(long id);
    public List<CourseResponseDTO> getAllCourse(Degree degree, Year year);
    public CourseResponseDTO update(CourseUpdateDTO courseUpdateDTO, long id);
}
