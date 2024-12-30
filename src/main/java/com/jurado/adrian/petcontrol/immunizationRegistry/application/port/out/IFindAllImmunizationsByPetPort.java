package com.jurado.adrian.petcontrol.immunizationRegistry.application.port.out;

import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

import java.util.List;

public interface IFindAllImmunizationsByPetPort {
    public List<Immunization> findAllImmunizationsByPet(Long petId);
}
