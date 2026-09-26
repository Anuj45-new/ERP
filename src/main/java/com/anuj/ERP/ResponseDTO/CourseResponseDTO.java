package com.anuj.ERP.ResponseDTO;

import com.anuj.ERP.ENUM.CourseType;
import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
public class CourseResponseDTO {
    // no need of validation as it is already validated
    private long id;
    private String name;
    private Degree degree;
    private Year year;
    private CourseType courseType;

}
