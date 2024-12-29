package com.jurado.adrian.petcontrol.user.application.port.in;

import com.jurado.adrian.petcontrol.user.application.dto.UserDTO;
import com.jurado.adrian.petcontrol.user.domain.User;

public interface IRegisterUser {
    User registerUser(UserDTO user);
}
