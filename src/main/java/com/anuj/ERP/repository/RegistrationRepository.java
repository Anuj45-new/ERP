package com.anuj.ERP.repository;

import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.model.Registration;
import com.anuj.ERP.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
    public Optional<Registration> findByStudentsAndYear(Students students, Year year);
}
