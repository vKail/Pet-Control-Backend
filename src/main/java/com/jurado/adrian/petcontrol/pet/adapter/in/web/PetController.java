package com.jurado.adrian.petcontrol.pet.adapter.in.web;

import com.jurado.adrian.petcontrol.pet.application.dto.PetDto;
import com.jurado.adrian.petcontrol.pet.application.port.in.*;
import com.jurado.adrian.petcontrol.pet.domain.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    private final IRegisterPet registerPet;
    private final IDeletePet deletePet;
    private final IFindPet findPet;
    private final IFindAllPets findAllPets;
    private final IUpdatePet updatePet;
    private final IFindAllByOwner findAllByOwner;

    public PetController(IRegisterPet registerPet, IDeletePet deletePet, IFindPet findPet, IFindAllPets findAllPets, IUpdatePet updatePet, IFindAllByOwner findAllByOwner) {
        this.registerPet = registerPet;
        this.deletePet = deletePet;
        this.findPet = findPet;
        this.findAllPets = findAllPets;
        this.updatePet = updatePet;
        this.findAllByOwner = findAllByOwner;
    }

    @PostMapping("/pets")
    public Pet registerPet(@RequestBody PetDto pet) {
        return registerPet.registerPet(pet);
    }

    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id) {
        deletePet.delete(id);
    }

    @GetMapping("/pets")
    public List<Pet> findAllPets() {
        return findAllPets.findAll();
    }

    @GetMapping("/pets/{id}")
    public Pet getPet(@PathVariable Long id) {
        return findPet.findById(id);
    }

    @GetMapping("/pets/owner/{ownerId}")
    public List<Pet> findAllByOwner(@PathVariable Long ownerId) {
        return findAllByOwner.findAllByOwner(ownerId);
    }

    @PutMapping("/pets/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody PetDto pet) {
        return updatePet.updatePet(id, pet);
    }
}
