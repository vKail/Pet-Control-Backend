package com.jurado.adrian.petcontrol.immunizationRegistry.application.port.in;

import com.jurado.adrian.petcontrol.immunizationRegistry.application.dto.ImmunizationDto;
import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

public interface IRegisterImmunization {
    public Immunization registerImmunization(ImmunizationDto immunization);
}
