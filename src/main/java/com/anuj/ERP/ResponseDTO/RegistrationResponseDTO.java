package com.anuj.ERP.ResponseDTO;

import com.anuj.ERP.ENUM.RegistrationType;
import com.anuj.ERP.ENUM.Year;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class RegistrationResponseDTO {

    private int id;
    private long suid;
    private String sname;
    private Year year;
    private RegistrationType registrationType;
    private List<Long> cid;
    private List<String> cname;
    private float fees;
    private LocalDateTime time;
}
