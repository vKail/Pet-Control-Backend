package com.jurado.adrian.petcontrol.petsPecimen.application.dto;

import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;

public class DtoMapper {
    public static SpecimenDto toDto(Specimen specimen) {
        SpecimenDto specimenDto = new SpecimenDto();
        specimenDto.setId(specimen.getId());
        specimenDto.setName(specimen.getName());
        return specimenDto;
    }

    public static Specimen toEntity(SpecimenDto specimenDto) {
        Specimen specimen = new Specimen();
        specimen.setName(specimenDto.getName());
        return specimen;
    }

}
