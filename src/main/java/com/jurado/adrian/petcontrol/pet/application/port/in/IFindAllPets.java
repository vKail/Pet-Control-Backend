package com.jurado.adrian.petcontrol.pet.application.port.in;

import com.jurado.adrian.petcontrol.pet.domain.Pet;

import java.util.List;

public interface IFindAllPets {
    List<Pet> findAll();
}
