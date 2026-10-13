package com.anuj.ERP.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Entity
public class Staff{

    @Id
    @NotNull
    @Min(1000000000L)
    @Max(10000000000L)
    private long sid;

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    @NotBlank
    private String email;

    @Past
    private LocalDate dob;

    @NotBlank
    private String password;

    @Column(unique = true)
    @Max(9999999999L)
    @Min(7000000000L)
    @NotNull
    private Long contact;

    @Column(nullable = false)
    private boolean enabled = true;

    public boolean getEnabled() {
        return enabled;
    }
}
