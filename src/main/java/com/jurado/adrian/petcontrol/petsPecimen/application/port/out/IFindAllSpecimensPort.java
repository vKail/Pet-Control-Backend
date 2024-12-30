package com.jurado.adrian.petcontrol.petsPecimen.application.port.out;

import com.jurado.adrian.petcontrol.petsPecimen.domain.Specimen;

import java.util.List;

public interface IFindAllSpecimensPort {
    public List<Specimen> findAllSpecimens();
}
