package com.jurado.adrian.petcontrol.pet.adapter.out.presistence;

import com.jurado.adrian.petcontrol.pet.domain.Pet;
import com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence.SpecimenEntity;
import com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence.SpecimenMapper;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.out.IFindSpecimenPort;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import com.jurado.adrian.petcontrol.user.adapter.out.persistence.UserEntity;
import com.jurado.adrian.petcontrol.user.adapter.out.persistence.UserMapper;
import com.jurado.adrian.petcontrol.user.application.port.out.IFindUserPort;
import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
    UserMapper userMapper;
    SpecimenMapper specimenMapper;
    IFindUserPort findUserPort;
    IFindSpecimenPort findSpecimenPort;

    public PetMapper(IFindUserPort findUserPort, UserMapper userMapper, SpecimenMapper specieMapper, IFindSpecimenPort findSpecimenPort) {
        this.findUserPort = findUserPort;
        this.userMapper = userMapper;
        this.specimenMapper = specieMapper;
        this.findSpecimenPort = findSpecimenPort;
    }
    public Pet toDomain (PetEntity petEntity){
        Pet pet = new Pet();
        pet.setId(petEntity.getId());
        pet.setName(petEntity.getName());
        pet.setBirthDate(petEntity.getBirthdate());
        pet.setGender(petEntity.getGender());
        pet.setOwnerId(petEntity.getOwner().getId());
        Specimen specie = findSpecimenPort.findSpecimenById(petEntity.getSpecimen().getId());
        pet.setSpecie(specie);
        return pet;
    }
    public PetEntity toEntity (Pet pet){
        PetEntity petEntity = new PetEntity();
        petEntity.setId(pet.getId());
        petEntity.setName(pet.getName());
        petEntity.setBirthdate(pet.getBirthDate());
        petEntity.setGender(pet.getGender());
        User owner = findUserPort.findById(pet.getOwnerId());
        UserEntity ownerEntity = userMapper.toUserEntity(owner);
        petEntity.setOwner(ownerEntity);
        Specimen specimen = findSpecimenPort.findSpecimenById(pet.getSpecie().getId());
        SpecimenEntity specieEntity = specimenMapper.toEntity(specimen);
        petEntity.setSpecimen(specieEntity);
        return petEntity;
    }
}
