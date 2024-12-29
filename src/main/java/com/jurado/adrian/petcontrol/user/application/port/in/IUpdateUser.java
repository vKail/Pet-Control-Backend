package com.jurado.adrian.petcontrol.user.application.port.in;

import com.jurado.adrian.petcontrol.user.application.dto.UserDTO;
import com.jurado.adrian.petcontrol.user.domain.User;

public interface IUpdateUser {
    User updateUser(Long id, UserDTO user);
}
