package com.jurado.adrian.petcontrol.immunizationRegistry.application.port.out;

import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

public interface IFindImmunizationPort {
    public Immunization findImmunization(Long id);
}
