package com.jurado.adrian.petcontrol.immunizationRegistry.application.port.in;

import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

import java.util.List;

public interface IFindAllImmunizationByPet {
    public List<Immunization> findAllByPet(Long petId);
}
