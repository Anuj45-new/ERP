package com.anuj.ERP.ResponseDTO;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentResponseDTO {

    private long uid;

    private String name;

    private String email;

    private LocalDate birthDate;

    private Degree degree;

    private Year year;

    private Long contact;
}
