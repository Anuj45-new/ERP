package com.anuj.ERP.serviceimpl.service;

import com.anuj.ERP.ResponseDTO.StaffResponseDTO;
import com.anuj.ERP.model.Staff;
import com.anuj.ERP.requestDTO.StaffUpdateDTO;
import org.springframework.stereotype.Service;

@Service
public interface StaffService {
    public StaffResponseDTO update(StaffUpdateDTO staffUpdateDTO, long sid);
}
