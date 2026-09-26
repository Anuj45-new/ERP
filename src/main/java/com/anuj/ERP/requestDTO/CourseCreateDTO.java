package com.anuj.ERP.requestDTO;

import com.anuj.ERP.ENUM.CourseType;
import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

// JPA related annotations should not be used in DTO ex column, table, neither enumerated
@Data
public class CourseCreateDTO {

    @NotBlank
    private String name;

    @NotNull
    private Degree degree;

    @NotNull
    private Year year;

    @NotNull
    private CourseType courseType;

}
