package com.anuj.ERP.requestDTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
// in Patch/updating we have options hence don't use NotBlank etc
public class StaffUpdateDTO {

    private String name;

    @Email
    private String email;

    @Past
    private LocalDate dob;

    @Size(min =8, max =15)
    private String password;

    private Long contact;
}
