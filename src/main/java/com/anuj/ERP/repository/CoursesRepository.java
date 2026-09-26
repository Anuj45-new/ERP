package com.anuj.ERP.repository;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
    public boolean existsByName(String name);
    public List<Courses> findByDegreeAndYear(Degree degree, Year year);
    public List<Courses> findByDegree(Degree degree);
    public List<Courses> findByYear(Year year);
}
