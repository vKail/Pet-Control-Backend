package com.jurado.adrian.petcontrol.pet.domain;

import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {
    private Long id;
    private String name;
    private Date birthDate;
    private String gender;
    private Specimen specie;
    private Long ownerId;
}
