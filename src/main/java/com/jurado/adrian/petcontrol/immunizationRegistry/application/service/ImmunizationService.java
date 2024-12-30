package com.jurado.adrian.petcontrol.immunizationRegistry.application.service;

import com.jurado.adrian.petcontrol.immunizationRegistry.application.dto.DtoMapper;
import com.jurado.adrian.petcontrol.immunizationRegistry.application.dto.ImmunizationDto;
import com.jurado.adrian.petcontrol.immunizationRegistry.application.port.in.*;
import com.jurado.adrian.petcontrol.immunizationRegistry.application.port.out.*;
import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImmunizationService implements IFindAllImmunizationByPet, IRegisterImmunization, IUpdateImmunization, IDeleteImmunization {
    IFindAllImmunizationsByPetPort findAllImmunizationsByPetPort;
    IRegisterImmunizationPort registerImmunizationPort;
    IUpdateImmunizationPort updateImmunizationPort;
    IDeleteImmunizationPort deleteImmunizationPort;
    IFindImmunizationPort findImmunizationPort;
    public ImmunizationService(IFindAllImmunizationsByPetPort findAllImmunizationsByPetPort, IRegisterImmunizationPort registerImmunizationPort, IUpdateImmunizationPort updateImmunizationPort, IDeleteImmunizationPort deleteImmunizationPort, IFindImmunizationPort findImmunizationPort) {
        this.findAllImmunizationsByPetPort = findAllImmunizationsByPetPort;
        this.registerImmunizationPort = registerImmunizationPort;
        this.updateImmunizationPort = updateImmunizationPort;
        this.deleteImmunizationPort = deleteImmunizationPort;
        this.findImmunizationPort = findImmunizationPort;
    }

    @Override
    public void deleteImmunization(Long id) {
        deleteImmunizationPort.deleteImmunization(id);
    }

    @Override
    public List<Immunization> findAllByPet(Long petId) {
        return findAllImmunizationsByPetPort.findAllImmunizationsByPet(petId);
    }

    @Override
    public Immunization registerImmunization(ImmunizationDto immunization) {
        return registerImmunizationPort.registerImmunization(DtoMapper.toDomain(immunization));
    }

    @Override
    public Immunization updateImmunization(Long id, ImmunizationDto immunization) {
        Immunization immunizationToUpdate = findImmunizationPort.findImmunization(id);
        immunizationToUpdate.setPetId(immunization.getPetId());
        immunizationToUpdate.setVaccine(immunization.getVaccine());
        immunizationToUpdate.setDate(immunization.getDate());
        return updateImmunizationPort.updateImmunization(immunizationToUpdate);
    }
}
