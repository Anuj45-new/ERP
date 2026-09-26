package com.anuj.ERP.model;

import com.anuj.ERP.ENUM.CourseType;
import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = "name"
        )
)
@Getter @Setter
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Enumerated(EnumType.STRING)
    private Year year;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @ManyToMany(
            mappedBy = "courses",
            fetch = FetchType.LAZY
    )
    private List<Registration> registrations;

}
