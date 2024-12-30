package com.jurado.adrian.petcontrol.immunizationRegistry.adapter.out.presistence;

import com.jurado.adrian.petcontrol.pet.adapter.out.presistence.PetEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "immunization")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImmunizationEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;
    @Column(name = "vaccine")
    private String vaccine;
    @Column(name = "date")
    private Date date;
}
