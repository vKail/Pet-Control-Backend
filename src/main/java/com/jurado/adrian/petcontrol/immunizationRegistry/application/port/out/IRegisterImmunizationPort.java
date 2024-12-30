package com.jurado.adrian.petcontrol.immunizationRegistry.application.port.out;

import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

public interface IRegisterImmunizationPort {
    public Immunization registerImmunization(Immunization immunization);
}
