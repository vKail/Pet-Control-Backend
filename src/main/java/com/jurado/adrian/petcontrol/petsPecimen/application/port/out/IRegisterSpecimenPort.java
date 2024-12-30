package com.jurado.adrian.petcontrol.petsPecimen.application.port.out;

import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;

public interface IRegisterSpecimenPort {
    public Specimen registerSpecimen(Specimen specimen);
}
