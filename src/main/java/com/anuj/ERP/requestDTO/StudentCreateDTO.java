package com.anuj.ERP.requestDTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class StudentCreateDTO {

    @NotNull
    @Min(1000000000L)
    @Max(10000000000L)
    private long uid;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max =15)
    private String password;

    @NotNull
    @Max(9999999999L)
    @Min(7000000000L)
    private Long contact;


}
