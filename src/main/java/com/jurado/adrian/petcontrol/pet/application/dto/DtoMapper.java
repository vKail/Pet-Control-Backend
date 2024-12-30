package com.jurado.adrian.petcontrol.pet.application.dto;

import com.jurado.adrian.petcontrol.pet.domain.Pet;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.out.IFindSpecimenPort;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    private final IFindSpecimenPort findSpecimenPort;
    public DtoMapper(IFindSpecimenPort findSpecimenPort) {
        this.findSpecimenPort = findSpecimenPort;
    }
    public static PetDto toDto(Pet pet) {
        PetDto petDto = new PetDto();
        petDto.setId(pet.getId());
        petDto.setName(pet.getName());
        petDto.setBirthDate(pet.getBirthDate());
        petDto.setGender(pet.getGender());
        petDto.setOwnerId(pet.getOwnerId());
        petDto.setSpecieId(pet.getSpecie().getId());
        return petDto;
    }

    public Pet toEntity(PetDto petDto) {
        Pet pet = new Pet();
        pet.setId(petDto.getId());
        pet.setName(petDto.getName());
        pet.setBirthDate(petDto.getBirthDate());
        pet.setGender(petDto.getGender());
        pet.setOwnerId(petDto.getOwnerId());
        Specimen specimen = findSpecimenPort.findSpecimenById(petDto.getSpecieId());
        pet.setSpecie(specimen);
        return pet;
    }
}
