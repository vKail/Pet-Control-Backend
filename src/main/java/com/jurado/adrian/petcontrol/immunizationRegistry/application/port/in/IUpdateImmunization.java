package com.jurado.adrian.petcontrol.immunizationRegistry.application.port.in;

import com.jurado.adrian.petcontrol.immunizationRegistry.application.dto.ImmunizationDto;
import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

public interface IUpdateImmunization {
    public Immunization updateImmunization(Long id,ImmunizationDto immunization);
}
