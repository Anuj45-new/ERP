package com.anuj.ERP.security;

import com.anuj.ERP.model.Staff;
import com.anuj.ERP.model.Students;
import com.anuj.ERP.repository.StaffRepository;
import com.anuj.ERP.repository.StudentsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentsRepository studentsRepository;
    private final StaffRepository staffRepository;

    public CustomUserDetailsService(
            StudentsRepository studentsRepository,
            StaffRepository staffRepository) {

        this.studentsRepository = studentsRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Long id;

        try {
            id = Long.parseLong(username);
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("Invalid user ID");
        }

        // First check Student
        Students student = studentsRepository.findById(id).orElse(null);

        if (student != null) {
            return new CustomUserDetails(student);
        }

        // Then check Staff
        Staff staff = staffRepository.findById(id).orElse(null);

        if (staff != null) {
            return new CustomUserDetails(staff);
        }

        throw new UsernameNotFoundException(
                "User not found with ID: " + id
        );
    }
}