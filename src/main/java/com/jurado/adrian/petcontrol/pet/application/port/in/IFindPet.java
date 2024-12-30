package com.jurado.adrian.petcontrol.pet.application.port.in;

import com.jurado.adrian.petcontrol.pet.domain.Pet;

public interface IFindPet {
    Pet findById(Long id);
}
