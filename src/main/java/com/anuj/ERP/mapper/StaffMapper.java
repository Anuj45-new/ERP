package com.anuj.ERP.mapper;

import com.anuj.ERP.ResponseDTO.StaffResponseDTO;
import com.anuj.ERP.model.Staff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter
@AllArgsConstructor
@Component
public class StaffMapper {

    public StaffResponseDTO update(Staff staff){
        StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
        staffResponseDTO.setName(staff.getName());
        staffResponseDTO.setEmail(staff.getEmail());
        staffResponseDTO.setContact(staff.getContact());
        staffResponseDTO.setDob(staff.getDob());
        staffResponseDTO.setSid(staff.getSid());
        return staffResponseDTO;
    }
}
