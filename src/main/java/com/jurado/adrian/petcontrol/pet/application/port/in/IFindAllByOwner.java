package com.jurado.adrian.petcontrol.pet.application.port.in;

import com.jurado.adrian.petcontrol.pet.domain.Pet;

import java.util.List;

public interface IFindAllByOwner {
    public List<Pet> findAllByOwner(Long ownerId);
}
