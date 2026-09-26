package com.anuj.ERP.serviceimpl;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.CourseResponseDTO;
import com.anuj.ERP.mapper.CourseMapper;
import com.anuj.ERP.model.Courses;
import com.anuj.ERP.repository.CoursesRepository;
import com.anuj.ERP.requestDTO.CourseCreateDTO;
import com.anuj.ERP.requestDTO.CourseUpdateDTO;
import com.anuj.ERP.serviceimpl.service.CoursesService;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class CoursesServiceImp implements CoursesService {

    private final CoursesRepository coursesRepository;
    private final CourseMapper courseMapper;

    @Override
    @Transactional
    public CourseResponseDTO createCourse(CourseCreateDTO courseCreateDTO) {
        if (coursesRepository.existsByName(courseCreateDTO.getName())) {
            throw new RuntimeException("Course is already existing");
        }
        Courses saved = coursesRepository.save(courseMapper.toEntity(courseCreateDTO));
        return courseMapper.toResponse(saved);
    }
    
    public CourseResponseDTO findCourse(long id){
        Courses courses = coursesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseMapper.toResponse(courses);
    }

    @Transactional
    public String deleteCourses(Degree degree, Year year){
        List<Courses> courses = new ArrayList<>();

        if(degree != null  && year!= null){
            courses = coursesRepository.findByDegreeAndYear(degree,year);
        }
        else if(degree!=null){
            courses = coursesRepository.findByDegree(degree);
        }
        else if(year != null){
            courses = coursesRepository.findByYear(year);
        }

        coursesRepository.deleteAll(courses);
        return "Course/s successfully deleted";
    }

    @Transactional
    public String deleteCourse(long id){
        Courses course = coursesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course id not found"));
        coursesRepository.delete(course);
        return "Course Successfully deleted";
    }

    public List<CourseResponseDTO> getAllCourse(Degree degree, Year year){
        List<Courses> courses = new ArrayList<>();

        if(degree != null  && year!= null){
            courses = coursesRepository.findByDegreeAndYear(degree,year);
        }
        else if(degree!=null){
            courses = coursesRepository.findByDegree(degree);
        }
        else if(year != null){
            courses = coursesRepository.findByYear(year);
        }
        else{
            courses = coursesRepository.findAll();
        }
        return courseMapper.toResponseList(courses);
    }

    @Transactional
    public CourseResponseDTO update(CourseUpdateDTO courses, long id){
        Courses c = coursesRepository.findById(id).orElseThrow(()-> new RuntimeException("Course not found"));
        c.setCourseType(courses.getCourseType());
        c.setDegree(courses.getDegree());
        c.setName(courses.getName());
        c.setYear(courses.getYear());
        return courseMapper.toResponse(c);
    }

}