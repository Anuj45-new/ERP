package com.anuj.ERP.controller;

import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.RegistrationResponseDTO;
import com.anuj.ERP.requestDTO.RegistrationCreateDTO;
import com.anuj.ERP.serviceimpl.RegistrationServiceImp;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/registration")
public class RegistrationController {

    private  final RegistrationServiceImp registrationService;

    public RegistrationController(RegistrationServiceImp registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<RegistrationResponseDTO> newRegistration(RegistrationCreateDTO registrationCreateDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(registrationService.newRegistration(registrationCreateDTO));
    }

    @GetMapping("/{uid}")
    public ResponseEntity<RegistrationResponseDTO> getRegistration(@PathVariable long uid, @RequestBody Year year){
        return ResponseEntity.status(HttpStatus.OK)
                .body(registrationService.getRegistration(uid,year));
    }
}
