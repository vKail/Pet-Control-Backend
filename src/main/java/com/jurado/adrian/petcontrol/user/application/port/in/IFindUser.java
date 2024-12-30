package com.jurado.adrian.petcontrol.user.application.port.in;

import com.jurado.adrian.petcontrol.user.domain.User;

public interface IFindUser {
    User findById(Long id);
}
