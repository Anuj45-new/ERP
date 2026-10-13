package com.anuj.ERP.serviceimpl;

import com.anuj.ERP.ResponseDTO.StaffResponseDTO;
import com.anuj.ERP.exception.ResourceNotFoundException;
import com.anuj.ERP.mapper.StaffMapper;
import com.anuj.ERP.model.Staff;
import com.anuj.ERP.repository.StaffRepository;
import com.anuj.ERP.requestDTO.StaffUpdateDTO;
import com.anuj.ERP.serviceimpl.service.StaffService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class StaffServiceImp implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public StaffResponseDTO update(StaffUpdateDTO staffUpdateDTO, long sid) {
        Staff stf = staffRepository.findById(sid)
                .orElseThrow(() -> new ResourceNotFoundException("Student with UID" + sid + "not found"));

        if(staffUpdateDTO.getName() != null){
            stf.setName(staffUpdateDTO.getName());
        }

        if(staffUpdateDTO.getContact() != null){
            stf.setContact(staffUpdateDTO.getContact());
        }

        if(staffUpdateDTO.getEmail() != null){
            stf.setEmail(staffUpdateDTO.getEmail());
        }

        if(staffUpdateDTO.getDob() != null){
            stf.setDob(staffUpdateDTO.getDob());
        }

        if(staffUpdateDTO.getPassword() != null){
            stf.setPassword(passwordEncoder.encode(staffUpdateDTO.getPassword()));
        }
        Staff updated = staffRepository.save(stf);

        return staffMapper.update(updated);
    }
}

