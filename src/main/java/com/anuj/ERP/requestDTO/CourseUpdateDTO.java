package com.anuj.ERP.requestDTO;

import com.anuj.ERP.ENUM.CourseType;
import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import lombok.*;

@Data
public class CourseUpdateDTO {

    private String name;

    private Degree degree;

    private Year year;

    private CourseType courseType;

}
