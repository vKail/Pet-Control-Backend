package com.jurado.adrian.petcontrol.petsPecimen.application.port.in;

import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;

import java.util.List;

public interface IFindAllSpecimen {
    public List<Specimen> findAllSpecimen();
}
