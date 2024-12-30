package com.jurado.adrian.petcontrol.immunizationRegistry.adapter.out.presistence;

import com.jurado.adrian.petcontrol.immunizationRegistry.application.dto.ImmunizationDto;
import com.jurado.adrian.petcontrol.immunizationRegistry.application.port.out.*;
import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ImmunizationPersistenceAdapter implements IRegisterImmunizationPort, IFindImmunizationPort ,IFindAllImmunizationsByPetPort, IUpdateImmunizationPort, IDeleteImmunizationPort {
    private final ImmunizationRepository repository;
    private final ImmunizationMapper mapper;

    public ImmunizationPersistenceAdapter(ImmunizationRepository repository, ImmunizationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Immunization findImmunization(Long id) {
        return mapper.toDomain(repository.findById(id).orElseThrow());
    }

    @Override
    public Immunization registerImmunization(Immunization immunization) {
        return mapper.toDomain(repository.save(mapper.toEntity(immunization)));
    }

    @Override
    public List<Immunization> findAllImmunizationsByPet(Long id) {
        return repository.findById(id).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Immunization updateImmunization(Immunization immunization) {
        return mapper.toDomain(repository.save(mapper.toEntity(immunization)));
    }

    @Override
    public void deleteImmunization(Long id) {
        repository.deleteById(id);
    }
}
