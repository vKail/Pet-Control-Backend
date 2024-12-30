package com.jurado.adrian.petcontrol.pet.application.port.in;

import com.jurado.adrian.petcontrol.pet.application.dto.PetDto;
import com.jurado.adrian.petcontrol.pet.domain.Pet;

public interface IRegisterPet {
    Pet registerPet(PetDto pet);
}
