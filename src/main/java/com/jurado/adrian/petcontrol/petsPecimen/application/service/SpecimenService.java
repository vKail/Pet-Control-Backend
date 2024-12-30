package com.jurado.adrian.petcontrol.petsPecimen.application.service;

import com.jurado.adrian.petcontrol.petsPecimen.application.dto.DtoMapper;
import com.jurado.adrian.petcontrol.petsPecimen.application.dto.SpecimenDto;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.in.*;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.out.*;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecimenService implements IFindAllSpecimen, IFindSpecimen, IRegisterSpecimen, IUpdateSpecimen, IDeleteSpecimen {
    private final IFindAllSpecimensPort findAllSpecimensPort;
    private final IFindSpecimenPort findSpecimenPort;
    private final IRegisterSpecimenPort registerSpecimenPort;
    private final IUpdateSpecimenPort updateSpecimenPort;
    private final IDeleteSpecimenPort deleteSpecimenPort;

    public SpecimenService(IFindAllSpecimensPort findAllSpecimensPort, IFindSpecimenPort findSpecimenPort, IRegisterSpecimenPort registerSpecimenPort, IUpdateSpecimenPort updateSpecimenPort, IDeleteSpecimenPort deleteSpecimenPort) {
        this.findAllSpecimensPort = findAllSpecimensPort;
        this.findSpecimenPort = findSpecimenPort;
        this.registerSpecimenPort = registerSpecimenPort;
        this.updateSpecimenPort = updateSpecimenPort;
        this.deleteSpecimenPort = deleteSpecimenPort;
    }

    @Override
    public void deleteSpecimen(Long id) {
        deleteSpecimenPort.deleteSpecimen(id);
    }

    @Override
    public List<Specimen> findAllSpecimen() {
        return findAllSpecimensPort.findAllSpecimens();
    }

    @Override
    public Specimen findSpecimenById(Long id) {
        return findSpecimenPort.findSpecimenById(id);
    }

    @Override
    public Specimen registerSpecimen(SpecimenDto specie) {
        return registerSpecimenPort.registerSpecimen(DtoMapper.toEntity(specie));
    }

    @Override
    public Specimen updateSpecimen(Long id, SpecimenDto specie) {
        Specimen specimenToUpdate = findSpecimenPort.findSpecimenById(id);
        specimenToUpdate.setName(specie.getName());
        return updateSpecimenPort.updateSpecimen(specimenToUpdate);
    }
}
