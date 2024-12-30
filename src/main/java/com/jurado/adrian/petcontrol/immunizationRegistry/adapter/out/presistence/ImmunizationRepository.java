package com.jurado.adrian.petcontrol.immunizationRegistry.adapter.out.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmunizationRepository extends JpaRepository<ImmunizationEntity, Long> {
}
