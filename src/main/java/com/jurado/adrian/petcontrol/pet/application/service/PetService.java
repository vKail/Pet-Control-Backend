package com.jurado.adrian.petcontrol.pet.application.service;


import com.jurado.adrian.petcontrol.pet.application.dto.DtoMapper;
import com.jurado.adrian.petcontrol.pet.application.dto.PetDto;
import com.jurado.adrian.petcontrol.pet.application.port.in.*;
import com.jurado.adrian.petcontrol.pet.application.port.out.*;
import com.jurado.adrian.petcontrol.pet.domain.Pet;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.out.IFindSpecimenPort;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements IRegisterPet, IFindAllPets, IFindPet, IUpdatePet, IDeletePet, IFindAllByOwner {
    private final IRegisterPetPort registerPetPort;
    private final IFindAllPetsPort findAllPetsPort;
    private final IFIndPetPort findPetPort;
    private final IUpdatePetPort updatePetPort;
    private final IDeletePetPort deletePetPort;
    private final IFindAllByOwnerPort findAllByOwnerPort;
    private final DtoMapper dtoMapper;
    private final IFindSpecimenPort findSpecimenPort;

    public PetService(
            IFIndPetPort findPetPort,
            IFindAllPetsPort findAllPetsPort,
            IRegisterPetPort registerPetPort,
            IUpdatePetPort updatePetPort,
            IDeletePetPort deletePetPort,
            DtoMapper dtoMapper,
            IFindSpecimenPort findSpecimenPort,
            IFindAllByOwnerPort findAllByOwnerPort
    ){
        this.findPetPort = findPetPort;
        this.findAllPetsPort = findAllPetsPort;
        this.registerPetPort = registerPetPort;
        this.updatePetPort = updatePetPort;
        this.deletePetPort = deletePetPort;
        this.dtoMapper = dtoMapper;
        this.findSpecimenPort = findSpecimenPort;
        this.findAllByOwnerPort = findAllByOwnerPort;
    }
    @Override
    public void delete(Long id) {
        deletePetPort.delete(id);
    }

    @Override
    public List<Pet> findAll() {
        return findAllPetsPort.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return findPetPort.findById(id);
    }

    @Override
    public Pet registerPet(PetDto pet) {
        Pet petToRegister = dtoMapper.toEntity(pet);
        return registerPetPort.registerPet(petToRegister);
    }

    @Override
    public Pet updatePet(Long id, PetDto pet) {
        Pet petToUpdate = findPetPort.findById(id);
        petToUpdate.setName(pet.getName());
        petToUpdate.setBirthDate(pet.getBirthDate());
        petToUpdate.setGender(pet.getGender());
        petToUpdate.setOwnerId(pet.getOwnerId());
        Specimen specie = findSpecimenPort.findSpecimenById(pet.getSpecieId());
        petToUpdate.setSpecie(specie);
        return updatePetPort.updatePet(petToUpdate);
    }


    @Override
    public List<Pet> findAllByOwner(Long ownerId) {
        return findAllByOwnerPort.findAllByOwner(ownerId);
    }
}
