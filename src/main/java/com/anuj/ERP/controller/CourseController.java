package com.anuj.ERP.controller;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.CourseResponseDTO;
import com.anuj.ERP.requestDTO.CourseCreateDTO;
import com.anuj.ERP.requestDTO.CourseUpdateDTO;
import com.anuj.ERP.serviceimpl.service.CoursesService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CoursesService coursesService;

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@Valid @RequestBody CourseCreateDTO courseCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(coursesService.createCourse(courseCreateDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCourse(@RequestParam (required = false) Degree degree,
                                             @RequestParam(required = false) Year year){

        if(degree == null  && year== null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return new ResponseEntity<>(coursesService.deleteCourses(degree, year),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(coursesService.deleteCourse(id));
    }
    // Response entity for giving back code, it should return response entity
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> findCourse(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(coursesService.findCourse(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourse(@RequestParam (required = false) Degree degree,
                                             @RequestParam(required = false) Year year){
        return ResponseEntity.status(HttpStatus.OK)
                .body(coursesService.getAllCourse(degree,year));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> update(@RequestBody CourseUpdateDTO courseUpdateDTO, @PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(coursesService.update(courseUpdateDTO,id));
    }
}
