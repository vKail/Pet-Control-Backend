package com.jurado.adrian.petcontrol.immunizationRegistry.adapter.in.web;

import com.jurado.adrian.petcontrol.immunizationRegistry.application.dto.ImmunizationDto;
import com.jurado.adrian.petcontrol.immunizationRegistry.application.port.in.*;

import com.jurado.adrian.petcontrol.immunizationRegistry.domain.Immunization;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImmunizationController {
    private final IRegisterImmunization registerImmunization;
    private final IFindAllImmunizationByPet findAllImmunizationByPet;
    private final IUpdateImmunization updateImmunization;
    private final IDeleteImmunization deleteImmunization;

    public ImmunizationController(IRegisterImmunization registerImmunization, IFindAllImmunizationByPet findAllImmunizationByPet, IUpdateImmunization updateImmunization, IDeleteImmunization deleteImmunization) {
        this.registerImmunization = registerImmunization;
        this.findAllImmunizationByPet = findAllImmunizationByPet;
        this.updateImmunization = updateImmunization;
        this.deleteImmunization = deleteImmunization;
    }

    @PostMapping("/immunization")
    public Immunization registerImmunization(@RequestBody ImmunizationDto immunization) {
        return registerImmunization.registerImmunization(immunization);
    }

    @PutMapping("/immunization/{id}")
    public Immunization updateImmunization(@PathVariable Long id, @RequestBody ImmunizationDto immunization) {
        return updateImmunization.updateImmunization(id, immunization);
    }

    @DeleteMapping("/immunization/{id}")
    public void deleteImmunization(@PathVariable Long id) {
        deleteImmunization.deleteImmunization(id);
    }

    @GetMapping("/immunization/pet/{petId}")
    public List<Immunization> findAllImmunizationByPet(@PathVariable Long petId) {
        return findAllImmunizationByPet.findAllByPet(petId);
    }



}
