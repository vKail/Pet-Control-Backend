package com.jurado.adrian.petcontrol.immunizationRegistry.application.dto;


import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;

public class DtoMapper {
    public static Immunization toDomain(ImmunizationDto immunizationDto){
        Immunization immunization = new Immunization();
        immunization.setId(immunizationDto.getId());
        immunization.setPetId(immunizationDto.getPetId());
        immunization.setVaccine(immunizationDto.getVaccine());
        immunization.setDate(immunizationDto.getDate());
        return immunization;
    }

    public static ImmunizationDto toDto(Immunization immunization){
        ImmunizationDto immunizationDto = new ImmunizationDto();
        immunizationDto.setId(immunization.getId());
        immunizationDto.setPetId(immunization.getPetId());
        immunizationDto.setVaccine(immunization.getVaccine());
        immunizationDto.setDate(immunization.getDate());
        return immunizationDto;
    }
}
