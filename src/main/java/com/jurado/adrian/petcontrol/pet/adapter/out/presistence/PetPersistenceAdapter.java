package com.jurado.adrian.petcontrol.pet.adapter.out.presistence;

import com.jurado.adrian.petcontrol.pet.application.port.out.*;
import com.jurado.adrian.petcontrol.pet.domain.Pet;
import com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence.SpecimenEntity;
import com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence.SpecimenMapper;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.out.IFindSpecimenPort;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import com.jurado.adrian.petcontrol.user.adapter.out.persistence.UserEntity;
import com.jurado.adrian.petcontrol.user.adapter.out.persistence.UserMapper;
import com.jurado.adrian.petcontrol.user.application.port.out.IFindUserPort;
import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PetPersistenceAdapter implements IRegisterPetPort, IFIndPetPort, IFindAllPetsPort, IUpdatePetPort, IDeletePetPort, IFindAllByOwnerPort {


    private final PetRepository petRepository;
    private final PetMapper petMapper;
    private final IFindUserPort findUserPort;
    private final IFindSpecimenPort findSpecimenPort;
    private final SpecimenMapper specimenMapper;
    private final UserMapper userMapper;
    public PetPersistenceAdapter(PetRepository petRepository, PetMapper petMapper, IFindUserPort findUserPort, UserMapper userMapper, IFindSpecimenPort findSpecimenPort, SpecimenMapper specimenMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
        this.findUserPort = findUserPort;
        this.userMapper = userMapper;
        this.findSpecimenPort = findSpecimenPort;
        this.specimenMapper = specimenMapper;
    }
    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).map(petMapper :: toDomain).orElseThrow();
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll().stream().map(petMapper :: toDomain).collect(Collectors.toList());
    }

    @Override
    public Pet registerPet(Pet pet) {
        PetEntity petEntity = petMapper.toEntity(pet);
        PetEntity savedPetEntity = petRepository.save(petEntity);
        return petMapper.toDomain(savedPetEntity);
    }

    @Override
    public Pet updatePet(Pet pet) {
        PetEntity savedPetEntity = petRepository.findById(pet.getId()).orElseThrow();
        savedPetEntity.setName(pet.getName());
        savedPetEntity.setGender(pet.getGender());
        savedPetEntity.setBirthdate(pet.getBirthDate());
        User owner = findUserPort.findById(pet.getOwnerId());
        UserEntity ownerEntity = userMapper.toUserEntity(owner);
        savedPetEntity.setOwner(ownerEntity);
        Specimen specimen = findSpecimenPort.findSpecimenById(pet.getSpecie().getId());
        SpecimenEntity specieEntity = specimenMapper.toEntity(specimen);
        savedPetEntity.setSpecimen(specieEntity);
        return petMapper.toDomain(savedPetEntity);
    }

    @Override
    public List<Pet> findAllByOwner(Long ownerId) {
        return petRepository.findAllByOwner_Id(ownerId).stream().map(petMapper :: toDomain).collect(Collectors.toList());
    }
}
