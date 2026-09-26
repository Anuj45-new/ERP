package com.anuj.ERP.controller;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.StudentResponseDTO;
import com.anuj.ERP.model.Students;
import com.anuj.ERP.requestDTO.StudentCreateDTO;
import com.anuj.ERP.requestDTO.StudentsUpdateDTO;
import com.anuj.ERP.serviceimpl.service.StudentsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentsService studentsService;

    @PatchMapping("/{uid}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@Valid @PathVariable long uid, @Valid @RequestBody StudentsUpdateDTO studentsUpdateDTO ){
        return ResponseEntity.status(HttpStatus.OK).
                body(studentsService.updateStudent(uid,studentsUpdateDTO));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentCreateDTO studentCreateDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentsService.addStudent(studentCreateDTO));
    }
    // here we don't need @Valid as it is mostly use in DTO verifications as well as @RequestBody as it is passed as string in URL not json
    @GetMapping("/{uid}")
    public ResponseEntity<StudentResponseDTO> getStudentByUID(@PathVariable @Valid long uid){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentsService.getStudentByUID(uid));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(@RequestParam (required = false) Degree degree,
                                                   @RequestParam(required = false) Year year){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentsService.getAllStudents(degree,year));
    }

    // we don't need to maintain the flow of URL here
    @DeleteMapping("/{uid}")
    public ResponseEntity<String> deleteStudent(@PathVariable @Valid long uid){
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.deleteStudent(uid));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllStudents(@RequestParam (required = false) Degree degree,
                               @RequestParam(required = false) Year year) {
        if( degree == null && year == null){
            return new ResponseEntity<>("Cannot delete all students",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentsService.deleteAllStudents(degree, year),HttpStatus.OK);
    }

//    @GetMapping("/csrf-token")
//    public CsrfToken getToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }
//
     @GetMapping("/session")
    public HttpSession gotSession(HttpServletRequest request){
        return request.getSession();
    }


}

