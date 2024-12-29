package com.jurado.adrian.petcontrol.user.application.port.out;

import com.jurado.adrian.petcontrol.user.domain.User;

public interface IFindUserPort {
    User findById(Long id);
}
