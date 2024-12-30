package com.jurado.adrian.petcontrol.immunizationRegistry.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Immunization {
    private Long id;
    private Long petId;
    private String vaccine;
    private Date date;
}
