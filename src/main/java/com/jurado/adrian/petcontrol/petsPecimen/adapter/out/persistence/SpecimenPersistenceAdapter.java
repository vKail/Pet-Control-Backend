package com.jurado.adrian.petcontrol.petsPecimen.adapter.out.persistence;

import com.jurado.adrian.petcontrol.petsPecimen.application.port.in.IRegisterSpecimen;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.out.*;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecimenPersistenceAdapter implements IFindAllSpecimensPort, IFindSpecimenPort, IRegisterSpecimenPort, IUpdateSpecimenPort, IDeleteSpecimenPort {
    SpecimenRepository specimenRepository;
    SpecimenMapper specimenMapper;
    public SpecimenPersistenceAdapter(SpecimenRepository specimenRepository, SpecimenMapper specimenMapper) {
        this.specimenRepository = specimenRepository;
        this.specimenMapper = specimenMapper;
    }

    @Override
    public void deleteSpecimen(Long id) {
        specimenRepository.deleteById(id);
    }

    @Override
    public List<Specimen> findAllSpecimens() {
        return specimenRepository.findAll().stream().map(specimenMapper :: toDomain).toList();
    }

    @Override
    public Specimen findSpecimenById(Long id) {
        return specimenRepository.findById(id).map(specimenMapper :: toDomain).orElseThrow();
    }

    @Override
    public Specimen registerSpecimen(Specimen specimen) {
        SpecimenEntity specimenEntity = specimenMapper.toEntity(specimen);
        SpecimenEntity savedSpecimenEntity = specimenRepository.save(specimenEntity);
        return specimenMapper.toDomain(savedSpecimenEntity);
    }

    @Override
    public Specimen updateSpecimen(Specimen specimen) {
        SpecimenEntity specimenEntity = specimenMapper.toEntity(specimen);
        SpecimenEntity savedSpecimenEntity = specimenRepository.findById(specimenEntity.getId()).orElseThrow();
        savedSpecimenEntity.setName(specimen.getName());
        specimenRepository.save(savedSpecimenEntity);
        return specimenMapper.toDomain(savedSpecimenEntity);
    }
}
