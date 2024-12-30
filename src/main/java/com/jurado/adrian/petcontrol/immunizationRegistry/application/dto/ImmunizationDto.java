package com.jurado.adrian.petcontrol.immunizationRegistry.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ImmunizationDto {

    private Long id;
    private Long petId;
    private String vaccine;
    private Date date;

}
