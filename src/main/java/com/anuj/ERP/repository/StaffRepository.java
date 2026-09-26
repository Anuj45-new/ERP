package com.anuj.ERP.repository;

import com.anuj.ERP.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {

    Staff findByName(String name);
}
