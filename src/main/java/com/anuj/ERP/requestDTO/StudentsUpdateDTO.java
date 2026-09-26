package com.anuj.ERP.requestDTO;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;

@Data
public class StudentsUpdateDTO {

    private String name;

    @Past
    private LocalDate birthDate;

    @Size(min = 8, max =15)
    private String password;

    private Degree degree;

    private Year year;

    private Long contact;
}


