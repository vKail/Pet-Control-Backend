package com.jurado.adrian.petcontrol.petsPecimen.application.port.in;

import com.jurado.adrian.petcontrol.petsPecimen.application.dto.SpecimenDto;
import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;

public interface IRegisterSpecimen {
    public Specimen registerSpecimen(SpecimenDto specie);
}
