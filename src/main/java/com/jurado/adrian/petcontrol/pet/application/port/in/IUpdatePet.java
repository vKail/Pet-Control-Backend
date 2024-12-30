package com.jurado.adrian.petcontrol.pet.application.port.in;

import com.jurado.adrian.petcontrol.pet.application.dto.PetDto;
import com.jurado.adrian.petcontrol.pet.domain.Pet;

public interface IUpdatePet {
    Pet updatePet(Long id, PetDto pet);
}
