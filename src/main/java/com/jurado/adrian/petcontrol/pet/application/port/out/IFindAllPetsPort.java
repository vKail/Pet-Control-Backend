package com.jurado.adrian.petcontrol.pet.application.port.out;

import com.jurado.adrian.petcontrol.pet.domain.Pet;

import java.util.List;

public interface IFindAllPetsPort {
    List<Pet> findAll();
}