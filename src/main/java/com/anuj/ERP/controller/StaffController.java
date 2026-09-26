package com.anuj.ERP.controller;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.CourseResponseDTO;
import com.anuj.ERP.ResponseDTO.StaffResponseDTO;
import com.anuj.ERP.ResponseDTO.StudentResponseDTO;
import com.anuj.ERP.model.Staff;
import com.anuj.ERP.requestDTO.CourseCreateDTO;
import com.anuj.ERP.requestDTO.StaffUpdateDTO;
import com.anuj.ERP.requestDTO.StudentCreateDTO;
import com.anuj.ERP.serviceimpl.service.CoursesService;
import com.anuj.ERP.serviceimpl.service.StaffService;
import com.anuj.ERP.serviceimpl.service.StudentsService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/Staff")
public class StaffController {

    // created it in final so that the reference ( = new xyz) cannot be changed later
    private final StaffService staffService;

    // RequestBody converts Json to object
    // @Valid is used to check whether the data formats are valid, these are set in resp model, dto
    // (staffService.login(request.sid, request.password) this calls method login from StaffService
    // Response Entity is used to tell client or ... that it is found/created etc., basically it sends http code
    // FOUND is for redirects

    // only one request body is possible
    @PatchMapping("/update/{sid}")
    public ResponseEntity<StaffResponseDTO> update(@Valid @RequestBody StaffUpdateDTO staffUpdateDTO, @PathVariable long sid){
        return ResponseEntity.status(HttpStatus.OK)
                .body(staffService.update(staffUpdateDTO,sid));
    }


}
