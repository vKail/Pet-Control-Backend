package com.jurado.adrian.petcontrol.immunizationRegistry.application.port.out;

import com.jurado.adrian.petcontrol.immunizationRegistry.application.dto.ImmunizationDto;
import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

public interface IUpdateImmunizationPort {
    public Immunization updateImmunization(Immunization immunization);
}
