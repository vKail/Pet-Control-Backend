package com.jurado.adrian.petcontrol.pet.application.port.out;

import com.jurado.adrian.petcontrol.pet.domain.Pet;

public interface IRegisterPetPort {
    Pet registerPet(Pet pet);
}
