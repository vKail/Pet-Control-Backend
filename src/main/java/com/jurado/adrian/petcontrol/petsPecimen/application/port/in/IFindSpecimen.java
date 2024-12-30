package com.jurado.adrian.petcontrol.petsPecimen.application.port.in;

import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;

public interface IFindSpecimen {
    public Specimen findSpecimenById(Long id);
}
