package com.anuj.ERP.model;

import com.anuj.ERP.ENUM.RegistrationType;
import com.anuj.ERP.ENUM.Year;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RegistrationType registrationType;

    @ManyToMany
    @JoinTable(
            name = "registration_courses",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Courses> courses;

    @Enumerated(EnumType.STRING)
    private Year year;


    private float fees;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Students students;

    @UpdateTimestamp
    private LocalDateTime time;


}
