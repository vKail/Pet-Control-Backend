package com.jurado.adrian.petcontrol.immunizationRegistry.adapter.out.presistence;

import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;
import com.jurado.adrian.petcontrol.pet.adapter.out.presistence.PetEntity;
import com.jurado.adrian.petcontrol.pet.adapter.out.presistence.PetMapper;
import com.jurado.adrian.petcontrol.pet.application.port.out.IFIndPetPort;
import com.jurado.adrian.petcontrol.pet.domain.Pet;
import org.springframework.stereotype.Component;

@Component
public class ImmunizationMapper {
    private final IFIndPetPort findPetPort;
    private final PetMapper petMapper;

    public ImmunizationMapper(IFIndPetPort findPetPort, PetMapper petMapper) {
        this.findPetPort = findPetPort;
        this.petMapper = petMapper;
    }

    public Immunization toDomain(ImmunizationEntity entity) {
        Immunization immunization = new Immunization();
        immunization.setId(entity.getId());
        immunization.setPetId(entity.getPet().getId());
        immunization.setVaccine(entity.getVaccine());
        immunization.setDate(entity.getDate());
        return immunization;
    }

    public ImmunizationEntity toEntity(Immunization immunization) {
        ImmunizationEntity entity = new ImmunizationEntity();
        entity.setId(immunization.getId());
        Pet pet = findPetPort.findById(immunization.getPetId());
        entity.setPet(petMapper.toEntity(pet));
        entity.setVaccine(immunization.getVaccine());
        entity.setDate(immunization.getDate());
        return entity;
    }
}
