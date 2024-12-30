package com.jurado.adrian.petcontrol.pet.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetDto {

    private Long id;
    private String name;
    private Date birthDate;
    private String gender;
    private Long specieId;
    private Long ownerId;
}
