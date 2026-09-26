package com.anuj.ERP.repository;

import com.anuj.ERP.ENUM.Degree;
import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.model.Students;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {
   // Optional<Students> findByuid(long uid);
    public boolean existsByEmail(String Email);
    public boolean existsByContact(long Contact);
    public List<Students> findByDegree(Degree degree);
    public List<Students> findByYear(Year year);
    public List<Students> findByDegreeAndYear(Degree degree, Year year);
    Students findByName(String name);
}
