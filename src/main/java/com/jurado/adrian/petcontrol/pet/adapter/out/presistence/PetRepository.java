package com.jurado.adrian.petcontrol.pet.adapter.out.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
    public List<PetEntity> findAllByOwner_Id(Long id);
}
