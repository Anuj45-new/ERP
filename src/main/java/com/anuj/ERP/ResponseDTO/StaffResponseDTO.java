package com.anuj.ERP.ResponseDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StaffResponseDTO {

    private long sid;
    private String name;
    private String email;
    private LocalDate dob;
    private Long contact;
}
