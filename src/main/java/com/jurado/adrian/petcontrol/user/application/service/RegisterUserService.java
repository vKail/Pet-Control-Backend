package com.jurado.adrian.petcontrol.user.application.service;

import com.jurado.adrian.petcontrol.user.application.dto.DtoMapper;
import com.jurado.adrian.petcontrol.user.application.dto.UserDTO;
import com.jurado.adrian.petcontrol.user.application.port.in.IRegisterUser;
import com.jurado.adrian.petcontrol.user.application.port.out.ISaveUserPort;
import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements IRegisterUser {
    private final ISaveUserPort saveUserPort;

    public RegisterUserService(ISaveUserPort saveUserPort) {
        this.saveUserPort = saveUserPort;
    }
    @Override
    public User registerUser(UserDTO user) {
        User userToCreate = DtoMapper.toDomain(user);
        return saveUserPort.save(userToCreate);
    }
}
