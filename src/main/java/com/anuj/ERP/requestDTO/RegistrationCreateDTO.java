package com.anuj.ERP.requestDTO;


import com.anuj.ERP.ENUM.RegistrationType;
import com.anuj.ERP.ENUM.Year;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class RegistrationCreateDTO {

    private RegistrationType registrationType;

    private List<Long> cid;

    private float fees;

    private long uid;

    private Year year;
}
