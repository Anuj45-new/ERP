package com.anuj.ERP.mapper;

import com.anuj.ERP.ResponseDTO.CourseResponseDTO;
import com.anuj.ERP.model.Courses;
import com.anuj.ERP.requestDTO.CourseCreateDTO;
import com.anuj.ERP.requestDTO.CourseUpdateDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component

public class CourseMapper {
    public Courses toEntity(CourseCreateDTO courseCreateDTO){
        Courses courses = new Courses();
        courses.setName(courseCreateDTO.getName());
        courses.setCourseType(courseCreateDTO.getCourseType());
        courses.setDegree(courseCreateDTO.getDegree());
        courses.setYear(courseCreateDTO.getYear());
        return courses;
    }

    public CourseResponseDTO toResponse(Courses courses){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId((courses.getId()));
        courseResponseDTO.setCourseType(courses.getCourseType());
        courseResponseDTO.setDegree(courses.getDegree());
        courseResponseDTO.setName(courses.getName());
        courseResponseDTO.setYear(courses.getYear());
        return courseResponseDTO;
    }

    public List<CourseResponseDTO> toResponseList(List<Courses> courses){
        List<CourseResponseDTO> courseResponseDTOS = new ArrayList<>();
        for(Courses c: courses){
            courseResponseDTOS.add(toResponse(c));
        }
        return courseResponseDTOS;
    }

}
