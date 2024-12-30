package com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence;

import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import org.springframework.stereotype.Component;

@Component
public class SpecimenMapper {
    public SpecimenEntity toEntity(Specimen specimen) {
        SpecimenEntity entity = new SpecimenEntity();
        entity.setId(specimen.getId());
        entity.setName(specimen.getName());
        return entity;
    }

    public Specimen toDomain(SpecimenEntity entity) {
        Specimen specimen = new Specimen();
        specimen.setId(entity.getId());
        specimen.setName(entity.getName());
        return specimen;
    }
}
