package com.anuj.ERP.serviceimpl.service;

import com.anuj.ERP.ENUM.Year;
import com.anuj.ERP.ResponseDTO.RegistrationResponseDTO;
import com.anuj.ERP.requestDTO.RegistrationCreateDTO;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {
    public RegistrationResponseDTO newRegistration(RegistrationCreateDTO registrationCreateDTO);
    public RegistrationResponseDTO getRegistration(long uid, Year year);
}
