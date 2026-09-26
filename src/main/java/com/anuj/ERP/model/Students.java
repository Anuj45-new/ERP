package com.anuj.ERP.model;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Students{

    @Id
    @NotNull
    @Min(1000000000L)
    @Max(10000000000L)
    private long uid;

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    @NotBlank
    private String email;

    @Past
    private LocalDate birthDate;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Enumerated(EnumType.STRING)
    private Year year;

    @Max(9999999999L)
    @Min(7000000000L)
    @Column(unique = true)
    @NotNull
    private Long contact;

    // In registration student id is stored as foreign key
    @OneToMany(
            mappedBy = "students",
            fetch = FetchType.LAZY
    )
    private List<Registration> registrations;


    }

