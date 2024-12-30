package com.jurado.adrian.petcontrol.pet.application.port.out;

import com.jurado.adrian.petcontrol.pet.domain.Pet;

public interface IFIndPetPort {
    Pet findById(Long id);
}
