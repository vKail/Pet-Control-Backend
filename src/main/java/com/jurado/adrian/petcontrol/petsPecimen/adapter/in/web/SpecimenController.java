package com.jurado.adrian.petcontrol.petsPecimen.adapter.in.web;

import com.jurado.adrian.petcontrol.petsPecimen.application.dto.SpecimenDto;
import com.jurado.adrian.petcontrol.petsPecimen.application.port.in.*;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecimenController {
    private final IDeleteSpecimen deleteSpecimen;
    private final IRegisterSpecimen registerSpecimen;
    private final IUpdateSpecimen updateSpecimen;
    private final IFindSpecimen findSpecimen;
    private final IFindAllSpecimen findAllSpecimen;

    public SpecimenController(IDeleteSpecimen deleteSpecimen, IRegisterSpecimen registerSpecimen, IUpdateSpecimen updateSpecimen, IFindSpecimen findSpecimen, IFindAllSpecimen findAllSpecimen) {
        this.deleteSpecimen = deleteSpecimen;
        this.registerSpecimen = registerSpecimen;
        this.updateSpecimen = updateSpecimen;
        this.findSpecimen = findSpecimen;
        this.findAllSpecimen = findAllSpecimen;
    }

    @GetMapping("/specimens")
    public List<Specimen> findAllSpecimen() {
        return findAllSpecimen.findAllSpecimen();
    }

    @GetMapping("/specimens/{id}")
    public Specimen findSpecimenById(@PathVariable Long id) {
        return findSpecimen.findSpecimenById(id);
    }

    @PostMapping("/specimens")
    public Specimen registerSpecimen(@RequestBody SpecimenDto specimen) {
        return registerSpecimen.registerSpecimen(specimen);
    }

    @PutMapping("/specimens/{id}")
    public Specimen updateSpecimen(@PathVariable Long id,@RequestBody SpecimenDto specimen) {
        return updateSpecimen.updateSpecimen(id, specimen);
    }

    @DeleteMapping("/specimens/{id}")
    public void deleteSpecimen(@PathVariable Long id) {
        deleteSpecimen.deleteSpecimen(id);
    }
}
